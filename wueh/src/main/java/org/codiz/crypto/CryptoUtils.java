package org.codiz.crypto;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {

    public void init(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128);
            generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
