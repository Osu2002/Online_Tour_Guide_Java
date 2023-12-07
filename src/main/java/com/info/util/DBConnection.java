package com.info.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends CommonUtil {
	
	private static Connection connection;
	
	private DBConnection() {
		
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		
		if(connection == null || connection.isClosed()) {
			
			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		
		return connection;
	}
	

}
