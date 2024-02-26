package org.codiz.encrypt;

import javax.crypto.SecretKeyFactory;
import java.security.KeyFactory;

public class encryption {

    // variable declaration
    private static final String SECRET_KEY = "mirowebob";
    private static final String SALT_VALUE = "dadanKimathi";

    //create an encryption method
    private static String encrypt(String toEncrypt){
        try {
            //initialize the byte array
            byte[] initVector = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            //create factory for keys
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            /*PBEKeySpec class implements KeySpec interface */
        }catch (Exception e){

        }
        return null;
    }
}
