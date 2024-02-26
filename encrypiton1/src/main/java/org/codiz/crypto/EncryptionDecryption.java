package org.codiz.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class EncryptionDecryption {
    private SecretKey key;
    private int Key_Size;

    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Key_Size);
        key = generator.generateKey();
    }
}
