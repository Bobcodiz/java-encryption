package org.codiz;

import org.codiz.crypto.Encryption;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Encryption encryption = new Encryption();
        try {
            encryption.init();
            String encrypted = encryption.encrypt("bob");
            String decrypted = encryption.decrypt(encrypted);

            System.out.println(encrypted +" is the encrypted");
            System.out.println(decrypted+" is the original");
        }catch (Exception e){
            System.out.println("exception occurred");

        }

    }
}