package com.codiz.java_encryption.cryptography;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

@Component
@Slf4j
public class SymmetricKey {

    private static final String AES = "AES";

    public static SecretKey secretAESKey() throws Exception{
        //creating an instance of secure random
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();

        // passing the string to the key generator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);

        //initializing the key generator to 256 bit
        keyGenerator.init(256,secureRandom);
        SecretKey key = keyGenerator.generateKey();
        log.info("The secret key is: ");
        return key;
    }
}
