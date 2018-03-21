package com.hijacking.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getDBConnection() {
        Connection connection = null;
        //  Database credentials
        String url = "jdbc:mysql://localhost:3306/sqlinjection?allowMultiQueries=true";
        String username = "root";
        String password = "";

        try {
        	//Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a database connection
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
