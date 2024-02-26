package org.codiz.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionDecryption {
    private SecretKey key;
    private int Key_Size = 128;
    private int tLen = 128;
    private byte[] IV;
    ;

    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(Key_Size);
        key = generator.generateKey();
    }

  /*  public void stringInitialization(String secretkey,String IV){
        key = new SecretKeySpec(decode(secretkey),"AES");
        this.IV = decode(IV);
    }*/
    public String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] messageToEncrypt = message.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        IV = encryptionCipher.getIV();
        GCMParameterSpec spec = new GCMParameterSpec(tLen,IV);
        encryptionCipher.init(Cipher.ENCRYPT_MODE,key,spec);
        byte[] encryptedMessage = encryptionCipher.doFinal(messageToEncrypt);
        return encode(encryptedMessage);
    }
    public void displayKeys(){
        System.out.println("secret key: "+encode(key.getEncoded()));
        System.out.println("IV : "+encode(IV));
    }
    public String decrypt(String encryptedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] message = decode(encryptedMessage);

        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(tLen,IV);
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
