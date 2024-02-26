package org.codiz.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionDecryption {
    private SecretKey key;
    private int Key_Size = 128;
    private int tLen = 128;
    Cipher encryptionCipher;

    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Key_Size);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] messageToEncrypt = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptedMessage = encryptionCipher.doFinal(messageToEncrypt);
        return encode(encryptedMessage);
    }
    public String decrypt(String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] message = decode(encryptedMessage);

        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(tLen,encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE,key,spec);
        byte[] decryptedMessage = decryptionCipher.doFinal(message);
        return new String(decryptedMessage);

    }

    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
}
