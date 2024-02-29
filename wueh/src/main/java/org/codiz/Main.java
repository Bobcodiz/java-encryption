package org.codiz;

import org.codiz.crypto.CryptoUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        CryptoUtils cryptoUtils = new CryptoUtils();
        cryptoUtils.init();
        String encoded = cryptoUtils.encrypt("MIROWE IS A GOOD MAN");
        String decoded = cryptoUtils.decrypt(encoded);

        System.out.println(encoded);
        System.out.println(decoded);

    }
}