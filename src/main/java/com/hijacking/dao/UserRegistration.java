package com.hijacking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.testng.Reporter;

import com.hijacking.util.LogMessage;

public class UserRegistration {

	public void deleteUsers() {

		try {
			Connection con = DBConnection.getDBConnection();
			String SQL = "delete from login";
			LogMessage.logMessage("Executing query" + SQL);
			PreparedStatement preparedStatement = con.prepareStatement(SQL);

			preparedStatement.executeUpdate();
			con.close();
			LogMessage.logMessage("Deleting successfull" + SQL);

		} catch (Exception ex) {
			LogMessage.logMessage("Error in deleting" + ex.getMessage());

			ex.printStackTrace();
		}

	}

	public int addUser(String username, String password, String name, String email) {

		try {
			Connection con = DBConnection.getDBConnection();

			LogMessage.logMessage("Made database connection");
			String SQL = "INSERT INTO login" + "(name, username, password) VALUES" + "(?,?,?)";

			LogMessage.logMessage("Executing query" + SQL);
			PreparedStatement preparedStatement = con.prepareStatement(SQL);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);

			preparedStatement.executeUpdate();
			LogMessage.logMessage("Unsecured user registration successfull");

			con.close();
		} catch (Exception ex) {
			LogMessage.logMessage("Error occured " + ex.getMessage());
			ex.printStackTrace();

			return -1;
		}

		return 1;
	}
}
