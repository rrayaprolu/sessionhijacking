package com.hijacking.dao.secured;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hijacking.util.BuildSql;

public class UserRegistrationSecured {

	public int addUser(String username, String password, String name, String email) {

		try {
			Connection con = SecuredDBConnection.getDBConnection();

			// Insert query to save the user details in the database
			String SQL = "INSERT INTO login" + "(name, username, hash) VALUES" + "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, BuildSql.buildLoginSql(username, password));

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			return -1;
		}

		return 1;
	}
}
