package com.oxygenxml.h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;

public class DBManager {
	/**
	 * Logger for logging.
	 */
	private static final Logger logger = Logger.getLogger(DBManager.class.getName());

	
	/**
	 * 
	 * 
	 * @param dbURL
	 * @param user
	 * @param password
	 * @param locations If null the default location folder is used for migration.
	 * 
	 * @throws SQLException
	 */
	public static void installDB(String dbURL, String user, String password, String[] additionalLocations) 
			throws SQLException {	    
	    Flyway flyway = new Flyway();
	    flyway.setDataSource(dbURL, user, password);
	    
	    if (additionalLocations != null) {
	    	ArrayList<String> locations = new ArrayList<>();
	    	locations.add("db/migration");
	    	locations.addAll(Arrays.asList(additionalLocations));
	    	
	    	logger.info("Load migrations: " + locations);
			flyway.setLocations(locations.toArray(new String[0]));
		}
	    
	    logger.info("Baseline...");
		flyway.baseline();
		logger.info("Migrate...");
	    flyway.migrate();
	    
	    DriverDataSource dataSource = (DriverDataSource) flyway.getDataSource();
	    Connection connection = dataSource.getConnection();
	    connection.close();
	    
	    logger.info("Database was installed");
	}
}
