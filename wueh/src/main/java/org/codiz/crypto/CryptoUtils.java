package org.codiz.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class CryptoUtils {
    private SecretKey SECRET_KEY;
    private byte[] IV;
    private int T_Len = 128;
    public void init(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128);
            SECRET_KEY = generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String encrypt(String message) throws Exception{

            byte[] messageToEncode = message.getBytes();
            Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE,SECRET_KEY);
            IV = encryptionCipher.getIV();
            byte[] encryptedBytes = encryptionCipher.doFinal(messageToEncode);
            return encode(encryptedBytes);

    }
   /* public void exports(){
        System.out.println("secret key :"+encode(SECRET_KEY.getEncoded()));
        System.out.println("IV : "+decode(Arrays.toString(IV)));
    }*/
    public String decrypt(String encryptedMessage){
        try {
            byte[] messageToDecrypt = decode(encryptedMessage);
            Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(T_Len,IV);
            decryptionCipher.init(Cipher.DECRYPT_MODE,SECRET_KEY,spec);
            byte[] decryptedBytes = decryptionCipher.doFinal(messageToDecrypt);
            return new String(decryptedBytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                 InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
}
