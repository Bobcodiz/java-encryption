package org.codiz.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;

public class encryption {

    // variable declaration
    private static final String SECRET_KEY = "mirowebob";
    private static final String SALT_VALUE = "dadanKimathi";

    //create an encryption method
    private static String encrypt(String toEncrypt){
        try {
            //initialize the byte array
            byte[] initVector = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
            //create factory for keys
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            /*PBEKeySpec class implements KeySpec interface */
            KeySpec keySpec = new PBEKeySpec(SECRET_KEY.toCharArray(),SALT_VALUE.getBytes(StandardCharsets.UTF_8),25536,256);
            SecretKey secret = keyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getEncoded(),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);
        }catch (Exception e){

        }
        return null;
    }
}
