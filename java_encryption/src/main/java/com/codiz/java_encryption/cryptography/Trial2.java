package com.codiz.java_encryption.cryptography;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Trial2 {

    private static final String AES = "AES";

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        // instance of the secure random
        SecureRandom secureRandom = new SecureRandom();

        //passing the string to the key generator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);

        keyGenerator.init(256,secureRandom);
        SecretKey key = keyGenerator.generateKey();
        return key;

    }
}
