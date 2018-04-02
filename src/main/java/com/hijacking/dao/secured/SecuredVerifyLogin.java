package com.hijacking.dao.secured;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hijacking.algorims.Sha;
import com.hijacking.util.BuildSql;
import com.hijacking.util.LogMessage;

public class SecuredVerifyLogin {

	public int verifyLogin(String username, String password) throws Exception {

		Connection con = SecuredDBConnection.getDBConnection();
		Statement statement = con.createStatement();

		String SQL = BuildSql.buildLoginSql(username, password);
		LogMessage.logMessage(SQL);

		String hash = Sha.calculateHash(SQL);

		ResultSet resultSet = statement.executeQuery("select * from login where hash = '" + hash + "'");
		int result = -1;

		if (resultSet.next()) {

			result = resultSet.getInt("id");
			LogMessage.logMessage("User found in database,login success");
			LogMessage.logMessage("User Details : ");
			LogMessage.logMessage("Id : " + resultSet.getInt("id") + " Username " + resultSet.getString("username")
					+ " Hash " + resultSet.getString("hash"));

		} else {
			LogMessage.logMessage("User not found in database, login failed");

			result = -1;
		}
		con.close();
		return result;
	}

}
