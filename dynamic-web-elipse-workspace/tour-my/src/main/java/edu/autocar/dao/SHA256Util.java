package edu.autocar.dao;

import java.security.MessageDigest;
import java.util.Random;

public class SHA256Util {
	public static String generateSalt() {
		byte[] salt = new byte[8];
		
		Random random = new Random();
		random.nextBytes(salt);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<salt.length; i++) {
			sb.append(String.format("%02x", salt[i]));
		}
		return sb.toString();
		
	}
	public static String getEncrypt(String source, String salt) {
		String result = "";
		String temp = source + salt;
		byte[] bytes = temp.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			byte[] byteData = md.digest();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
