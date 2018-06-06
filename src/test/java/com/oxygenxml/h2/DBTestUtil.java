package com.oxygenxml.h2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Commit;
import net.sf.jsqlparser.statement.SetStatement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.UseStatement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.AlterView;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.execute.Execute;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.merge.Merge;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.upsert.Upsert;
import ro.sync.basic.io.IOUtil;

public class DBTestUtil {
	
	/**
	 * Logger for logging.
	 */
	private static final Logger logger = Logger.getLogger(DBTestUtil.class.getName());

	private static String H2_DB_DRIVER = "org.h2.Driver";
	private static String DB_TEST_USER = "sa";
	private static String DB_PASSWORD = "";
	
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    
    public void initDB() throws SQLException, IOException, JSQLParserException {
		Connection h2Connection = getH2Connection();
		
		Statement statement = h2Connection.createStatement();
		logger.info("Init DB");
		net.sf.jsqlparser.statement.Statement parse = 
				CCJSqlParserUtil.parse(new FileInputStream(new File("src/test/resources/db/db_structure/comments.sql")));
		
		parse.accept(new StatementVisitor() {
			
			@Override
			public void visit(UseStatement use) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Upsert upsert) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Select select) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Merge merge) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(SetStatement set) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Execute execute) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Statements stmts) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Alter alter) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(AlterView alterView) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(CreateView createView) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(CreateTable createTable) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(CreateIndex createIndex) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Truncate truncate) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Drop drop) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Replace replace) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Insert insert) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Update update) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Delete delete) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visit(Commit commit) {
				// TODO Auto-generated method stub
				
			}
		});
//		statement.executeUpdate(IOUtil.readFile());
//		logger.info("Update DB");
		
		h2Connection.close();
		
		
	}
    
    public static Connection getH2Connection() {
    	Connection dbConnection = null;
        try {
            Class.forName(H2_DB_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error(e, e);
        }
        try {
            dbConnection = DriverManager.getConnection(
            		DB_CONNECTION, 
            		DB_TEST_USER,
                    DB_PASSWORD);            
        } catch (SQLException e) {
        	logger.error(e, e);
        }
        return dbConnection;
	}

    public static void main(String[] args) throws SQLException, IOException {
		new DBTestUtil().initDB();
	}
}
