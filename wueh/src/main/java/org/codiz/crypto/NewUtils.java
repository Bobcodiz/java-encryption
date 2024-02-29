package org.codiz.crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
public class NewUtils {
        private SecretKey SECRET_KEY;
        private byte[] IV;

        public void init() {
            try {
                KeyGenerator generator = KeyGenerator.getInstance("AES");
                generator.init(128);
                SECRET_KEY = generator.generateKey(); // Store the generated key
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public String encrypt(String message) throws Exception {
            SecureRandom secureRandom = new SecureRandom();
            IV = new byte[12];
            secureRandom.nextBytes(IV);

            Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY, new GCMParameterSpec(128, IV));
            byte[] encryptedBytes = encryptionCipher.doFinal(message.getBytes());
            return encode(IV) + encode(encryptedBytes); // Return IV + encrypted data
        }

        public String decrypt(String encryptedMessage) {
            try {
                byte[] iv = decode(encryptedMessage.substring(0, 16)); // Extract IV
                byte[] messageToDecrypt = decode(encryptedMessage.substring(16));

                Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
                decryptionCipher.init(Cipher.DECRYPT_MODE, SECRET_KEY, new GCMParameterSpec(128, iv));
                byte[] decryptedBytes = decryptionCipher.doFinal(messageToDecrypt);
                return new String(decryptedBytes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public String encode(byte[] data) {
            return Base64.getEncoder().encodeToString(data);
        }

        public byte[] decode(String data) {
            return Base64.getDecoder().decode(data);
        }

    public static void main(String[] args) throws Exception {
        NewUtils utils = new NewUtils();
        utils.init();
        String message = utils.encrypt("Bobby");
        String dec = utils.decrypt(message);

        System.out.println(message);
        System.out.println(dec);
    }

}
