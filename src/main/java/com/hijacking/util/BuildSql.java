package com.hijacking.util;

public class BuildSql {

	public static String buildLoginSql(String username, String password) {

		
		return "select * from login where username='" + username + "' and password = '" + password + "'";
	}

}
