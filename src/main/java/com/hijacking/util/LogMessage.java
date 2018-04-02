package com.hijacking.util;

import org.testng.Reporter;

public class LogMessage {

	public static  boolean logReporter =true;
	
	public static void logMessage(String message) {

		if(logReporter)
		Reporter.log(message + "\n");
		System.out.println(message);
	}

//	public static void main(String[] args) {
//		Calendar c = Calendar.getInstance();
//		c.setFirstDayOfWeek(1);
//		c.set(Calendar.WEEK_OF_YEAR, 18);
//		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//		System.out.println(String.valueOf(c.get(Calendar.DATE)));
//		System.out.println(c.getTime()+" "+c.getFirstDayOfWeek());
//
//		c = Calendar.getInstance();
//		c.set(Calendar.WEEK_OF_YEAR, 13);
//		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//		System.out.println(String.valueOf(c.get(Calendar.DATE)));
//		System.out.println(c.getTime());
//	}
}
