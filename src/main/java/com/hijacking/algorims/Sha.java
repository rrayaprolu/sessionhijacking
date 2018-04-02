package com.hijacking.algorims;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.hijacking.util.LogMessage;

public class Sha {

	public static String calculateHash(String password) {
		
		LogMessage.logMessage("Calculating hash value for "+password+" Using SHA-256 ");
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		LogMessage.logMessage("Hex format : " + sb.toString());

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		LogMessage.logMessage("Hex format : " + hexString.toString());
		return hexString.toString();
	}
}
