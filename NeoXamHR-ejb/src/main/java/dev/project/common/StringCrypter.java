package dev.project.common;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class StringCrypter {

private static String strKey = "neoXamHR";
   
public static String encrypt(String strClearText) throws Exception{
    	String strData="";
    	
    	try {
    		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
    		Cipher cipher=Cipher.getInstance("Blowfish");
    		cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
    		byte[] encrypted=cipher.doFinal(strClearText.getBytes());
    		strData=new String(encrypted);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e);
    	}
    	return strData;
    }    
  
public static String decrypt(String strEncrypted) throws Exception{
    	String strData="";
    	
    	try {
    		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
    		Cipher cipher=Cipher.getInstance("Blowfish");
    		cipher.init(Cipher.DECRYPT_MODE, skeyspec);
    		byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
    		strData=new String(decrypted);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e);
    	}
    	return strData;
    }

}
