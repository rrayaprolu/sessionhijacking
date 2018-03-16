package com.detectsqlinj.algorithms;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {

	public static String md5Password(String input) {
		try {
		
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(input.getBytes());
			BigInteger number = new BigInteger(1, digest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (Exception e) {

			e.printStackTrace();
			return input;
		}
	}

}
