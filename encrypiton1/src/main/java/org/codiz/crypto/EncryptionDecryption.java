package org.codiz.crypto;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionDecryption {
    private SecretKey key;
    private int Key_Size;

    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Key_Size);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] messageToEncrypt = message.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptedMessage = encryptionCipher.doFinal(messageToEncrypt);
        return encode(encryptedMessage);
    }

    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
}
