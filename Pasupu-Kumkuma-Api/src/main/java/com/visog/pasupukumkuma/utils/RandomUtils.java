package com.visog.pasupukumkuma.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtils {

	static final String ABN = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	static Random random = new Random();
	static String characters = "1234567890";


	public static String getRandomCharString(int length) {
		StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
	
	public static String getRandomAlphaNumericString(int length) {
		StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( ABN.charAt( rnd.nextInt(ABN.length()) ) );
		   return sb.toString();
	}
	
	public static String getRandomNumericString(int length) {
		char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getRandomAlphaNumericString(8));
	}

}
