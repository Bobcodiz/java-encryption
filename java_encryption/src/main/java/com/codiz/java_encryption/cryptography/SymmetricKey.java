package com.codiz.java_encryption.cryptography;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SymmetricKey {

    private static final String AES = "AES";

    public static SecretKey secretAESKey() throws Exception{
        //creating an instance of secure random
        SecureRandom secureRandom = new SecureRandom();

        // passing the string to the key generator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);

        //initializing the key generator to 256 bit
        keyGenerator.init(256,secureRandom);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }
}
