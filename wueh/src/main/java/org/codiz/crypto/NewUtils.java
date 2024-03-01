package org.codiz.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class NewUtils {
    private SecretKey secretKey;

    private int T_Len=128;
    private byte[] IV;

    public SecretKey init() throws Exception{
        int size = 256;
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(size);
        secretKey= generator.generateKey();
        return secretKey;
    }

    public String encrypt(String message)throws Exception{
        byte[] messageBytes = message.getBytes();
        Cipher encryptionCipher  = Cipher.getInstance
                ("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec
                (T_Len,IV);
        encryptionCipher.init(Cipher.ENCRYPT_MODE,secretKey,spec);
        /*IV = encryptionCipher.getIV();*/
        byte[] encryptedBytes = encryptionCipher.doFinal(messageBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage)throws Exception{
        byte[] messageBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance
                ("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_Len,IV);
        decryptionCipher.init(Cipher.DECRYPT_MODE,secretKey,spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageBytes);
        return new String(decryptedBytes);
    }

    private String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
    public void initFromStrings(String Key,String IV)
    {
        secretKey = new SecretKeySpec(decode(Key),"AES");
        this.IV =decode(IV);
    }
    public String exportKeys(){
        System.out.println("Secret Key :"+encode(secretKey.getEncoded()));
        System.out.println("iv :"+encode(IV));
        return null;
    }
    public static void main(String[] args) throws Exception {
        NewUtils utils = new NewUtils();
        utils.initFromStrings("3k8C9JS6p0d4LwgF+PSa9a4qjNWPh/klCJC3Lm0wmuY=","cfXyXPfwgggkgp0c");
       /* String message = utils.encrypt("Bobby");*/
        String dec = utils.decrypt("HE7AxgtG/xOUEoP9BcjbxP6tPWJs");


       /* System.out.println(message);*/
        System.out.println(dec);

    }

}
