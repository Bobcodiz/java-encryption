package com.codiz.enc.encryption;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class EncryptionUtils {
    private EncryptionKeysUtils encryptionKeysUtils;

    public String encrypt(String textToEncrypt, SecretKey secretKey, IvParameterSpec iv)
            throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {
        Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE,secretKey,iv);
        byte[] encryptedBytes = encryptionCipher.doFinal();textToEncrypt.getBytes();
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
