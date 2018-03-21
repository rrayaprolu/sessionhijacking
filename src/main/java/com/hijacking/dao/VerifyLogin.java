package com.hijacking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyLogin {

	public int verifyLogin(String username, String password) throws Exception {

		Connection con = DBConnection.getDBConnection();
		Statement statement = con.createStatement();

		String SQL = "select * from login where username='" + username
				+ "' and password = '" + password + "'";

		System.out.println(SQL);
		ResultSet resultSet = statement.executeQuery(SQL);
		int result = -1;

		if (resultSet.next()) {

			result = resultSet.getInt("id");
		} else {
			result = -1;
		}
		con.close();
		return result;
	}
	
	

}
