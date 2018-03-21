package com.hijacking.dao.secured;


import java.sql.Connection;
import java.sql.DriverManager;

public class SecuredDBConnection {

    public static Connection getDBConnection() {
        Connection connection = null;
        //  Database credentials
        String url = "jdbc:mysql://localhost:3306/sqlinjectionsecured?allowMultiQueries=true";
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
