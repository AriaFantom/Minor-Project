package com.healthify.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/minorproject";
    private static final String User = "root";
    private static final String Pass = "1234";
    
    static {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(URL, User, Pass);
    }
}
