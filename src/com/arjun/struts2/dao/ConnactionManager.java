package com.arjun.struts2.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.arjun.appconstant.ApplicationConstant;

public class ConnactionManager {
	private final static Logger LOGGER = Logger.getLogger(ConnactionManager.class.getName());

	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		Properties prop = new Properties();
		InputStream input = null;
		String filename = "dbconfig.properties";
		input = ConnactionManager.class.getClassLoader().getResourceAsStream(filename);
		// load a properties file
		prop.load(input);
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", prop.getProperty(ApplicationConstant.DB_USER_NAME));
		connectionProps.put("password",prop.getProperty(ApplicationConstant.DB_PASSWORDE));
		 // Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager
				.getConnection(
						"jdbc:" + prop.getProperty(ApplicationConstant.DB_NAME) + "://" + prop.getProperty(ApplicationConstant.SERVER_NAME) + ":"
								+ prop.getProperty(ApplicationConstant.PORT_NUMBER) + "/" + prop.getProperty(ApplicationConstant.SCHEMA_NAME),
						connectionProps);
		LOGGER.info("Connected to database");
		return conn;
	}
}
