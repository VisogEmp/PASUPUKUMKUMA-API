package com.visog.pasupukumkuma.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class PasswordSecurityUtils {

	private static final Logger logger = Logger.getLogger(PasswordSecurityUtils.class);
	private static final String AES_KEY = "y640uaUQD4b3xWV5";
	private static final String AES_INIT_VECTOR = "GHgnuUjYRApezIaV";
	

	/**
	 * This method encrypts the given plain string to cipher text
	 * @param value
	 * @return
	 */
	public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(AES_KEY.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(AES_INIT_VECTOR.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
           logger.error("Error in Password encryption", e);
           return null;
        }
    }

	/**
	 * This method decrypts the given cipher text to plain string
	 * @param encrypted
	 * @return
	 */
    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(AES_KEY.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(AES_INIT_VECTOR.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    /**
     * This method hashes the given string by using SHA-256 algorithm
     * @param password
     * @return
     */
    public static String hash256String(String password) {
    	return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
    }
    
    public static void main(String[] args) {
        String str = "Newpass2@";
        System.out.println(hash256String(str));
        String str1 = "93d363499a76911afbae5d1b12531c8842e644ca575b6d5e18e75c0778867e60";
//        System.out.println(encrypt(str1));
        
        String str2 = "hcdYQqzB";
        System.out.println(hash256String(str2));
        System.out.println(encrypt(hash256String(str2)));
        
        String dbStr = "Bp7rnd8LGI6kKcwiW7AMsldyczy1o5ttdaz3Lc9EkwDItJReUaPUqaBKW9FeqjM3vqFwo/VmSddcaagWVtccbQdoVS44W1Vva34xVuoSiysPf8OL2vJfgfNOmLouNE6yoCvdkfgN16IYr0y7gOfpaA==";
        System.out.println(decrypt(dbStr));
      //  +Bw8JEUaTYVmwlKpHU1IuDXwDLEHSqPK03z/TBYINkpK6LELa8RAlE76s7NLUOpAjc7ULEqDl6hKoW+ZfsTgs6B2jKtXdpE3HCFyKjStYO0=

    }
}
