package com.hijacking.dao.secured;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hijacking.algorims.Sha;
import com.hijacking.dao.DBConnection;
import com.hijacking.util.BuildSql;
import com.hijacking.util.LogMessage;

public class UserRegistrationSecured {

	public void deleteUsers() {

		try {
			Connection con = SecuredDBConnection.getDBConnection();
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
			Connection con = SecuredDBConnection.getDBConnection();

			// Insert query to save the user details in the database
			String SQL = "INSERT INTO login" + "(name, username, hash) VALUES" + "(?,?,?)";
			LogMessage.logMessage("Executing sql " + SQL);
			PreparedStatement preparedStatement = con.prepareStatement(SQL);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);

			String loginSQL = BuildSql.buildLoginSql(username, password);
			LogMessage.logMessage("Login sql " + loginSQL);

			String hash = Sha.calculateHash(loginSQL);

			preparedStatement.setString(3, hash);

			preparedStatement.executeUpdate();
			LogMessage.logMessage("User saved in database");

		} catch (Exception ex) {

			LogMessage.logMessage("Error in storing in sql" + ex.getMessage());
			return -1;
		}

		return 1;
	}
}
