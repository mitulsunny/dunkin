package com.dunkin.shadman.onlineStore.helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

public class DatabaseHelper {
	private static Logger log = LoggerHelper.getLogger(DatabaseHelper.class);
	private static String url = "jdbc:mysql://localhost:8889/rao_int";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";
	private static Connection connection;
	private static DatabaseHelper instance = null;
	
	/**
	 * please use DatabaseHelper.getInstance();
	 * instead of creating new instance
	 */
	
	public DatabaseHelper() {
		log.info("setting up connection!");
		connection = getSingleInstanceConnection();
	}
	
	public static DatabaseHelper getInstance() {
		if(instance == null) {
			log.info("DatabaseHelper instance is null. Creating new instance.");
			instance = new DatabaseHelper();
			log.info("DatabaseHelper New instance creation successfull.");
		}
		
		log.info("DatabaseHelper Returned!");
		return instance;
	}
	
	private Connection getSingleInstanceConnection() {
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, username, password);
				if(connection!=null) {
					log.info("Connection succesfull. Connected to database");
				} else {
					log.error("Connection failed!");
				}
			} 
			catch(SQLException ex) {
				log.error("Failed to create Database "+ex );
			}
		} catch(ClassNotFoundException e) {
			log.info("Driver not found");
		}
		
		return connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static ResultSet getResultSet(String dbQuery) {
		instance = DatabaseHelper.getInstance();
		connection = instance.getConnection();
		
		log.info("Executing Query: " + dbQuery);
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(dbQuery);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
