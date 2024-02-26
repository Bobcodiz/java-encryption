package org.codiz.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Encryption {
    private SecretKey SECRET_kEY;
    private int KEY_SIZE = 128;
    private Cipher encryptionCipher;
    private int T_LEN = 128;

    /*create a method to initialize our secret key*/
    public void init() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        SECRET_kEY = keyGenerator.generateKey();
    }

    /*create a method to encrypt the message*/
    public String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //get the byte[] of the message
        byte[] messageToEncrypt = message.getBytes();
        //create an encryption cipher
         encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        /*initialize the cipher to encryption cipher*/
        encryptionCipher.init(Cipher.ENCRYPT_MODE,SECRET_kEY);
        /*Starting encryption*/
        byte[] encryptedMessage = encryptionCipher.doFinal(messageToEncrypt);
        return encrypt(encryptedMessage);
    }
    //create a method to decrypt the encrypted message

    public String decrypt(String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] message = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN,encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE,SECRET_kEY,spec);
        byte[] decryptedMessage = decryptionCipher.doFinal(message);
        return new String(decryptedMessage);
    }

    public String encrypt(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
}
