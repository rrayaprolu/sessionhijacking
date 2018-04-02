package com.hijacking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hijacking.util.LogMessage;

public class VerifyLogin {

	public int verifyLogin(String username, String password) throws Exception {

		Connection con = DBConnection.getDBConnection();
		Statement statement = con.createStatement();

		String SQL = "select * from login where username='" + username
				+ "' and password = '" + password + "'";

		LogMessage.logMessage("Executig "+SQL);
		ResultSet resultSet = statement.executeQuery(SQL);
		int result = -1;

		if (resultSet.next()) {

			result = resultSet.getInt("id");
			LogMessage.logMessage("User found in database,login success");
			LogMessage.logMessage("User Details : ");
			LogMessage.logMessage("Id : " + resultSet.getInt("id") + " Username " + resultSet.getString("username")
					+ " Password " + resultSet.getString("password"));

		} else {
			LogMessage.logMessage("User not found in database, login failed");

			result = -1;
		}
		con.close();
		return result;
	}
	
	

}
