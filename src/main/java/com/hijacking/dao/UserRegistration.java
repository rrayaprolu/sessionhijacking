package com.hijacking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegistration {

	public int addUser(String username, String password, String name,String email) {

		try {
			Connection con = DBConnection.getDBConnection();

			//Insert query to save the user details in the database
			String SQL = "INSERT INTO login"
					+ "(name, username, password) VALUES" + "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			
			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			return -1;
		}

		return 1;
	}
}
