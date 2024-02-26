package org.codiz;

import org.codiz.crypto.Encryption;
import org.codiz.crypto.EncryptionDecryption;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EncryptionDecryption encryptionDecryption = new EncryptionDecryption();
        try {
            encryptionDecryption.init();
            encryptionDecryption.displayKeys();
        }catch (Exception e){
            System.out.println("exception occurred");

        }

    }
}