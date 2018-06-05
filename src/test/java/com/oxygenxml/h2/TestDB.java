package com.oxygenxml.h2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TestDB {
	/**
	 * Logger for logging.
	 */
	private static final Logger logger = Logger.getLogger(TestDB.class.getName());
	
	
	private File tempDBFile;

	private String dbURL;
	static final String JDBC_DRIVER = "org.h2.Driver";


	private String user = "wh";  
	
	
	

	@BeforeClass
	public void installDB() throws Exception {	    	    
//	    tempDBFile = File.createTempFile("file", ".db");
//	    tempDBFile.deleteOnExit();
		tempDBFile = new File("test/h2-r.db");
		System.out.println("Write DB to " + tempDBFile.getAbsolutePath());
		
	    dbURL = "jdbc:h2:file:" + tempDBFile.getAbsolutePath();	    
		DBManager.installDB(dbURL, user, null , null);
	}
	

	@Test
	public void testInstallDB() throws Exception {
	      Connection conn = null; 
	      Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(dbURL, user,null);  
	         
	         //STEP 3: Execute a query 
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
	         String sql =  "SELECT * FROM test_user";  
	         ResultSet executeQuery = stmt.executeQuery(sql);
	         System.out.println("Created table in given database..."); 
	         
	         while (executeQuery.next()) {
	        	 String name = executeQuery.getString("name");
	        	 System.out.println("name: " + name);
	         }
	         // STEP 4: Clean-up environment 
	         stmt.close(); 
	         conn.close(); 
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	         try { 
	            if(conn!=null) conn.close(); 
	         } catch(SQLException se){ 
	            se.printStackTrace(); 
	         } //end finally try 
	      } //end try 
	      System.out.println("Goodbye!");
	   } 
}
