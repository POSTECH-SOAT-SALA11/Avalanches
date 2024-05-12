package com.avalanches.core.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionUtils {

    private static final String ENCRYPTION_PASSWORD = "capivara"; //

    public static String encrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(ENCRYPTION_PASSWORD);
        return textEncryptor.encrypt(text);
    }

    public static String decrypt(String encryptedText) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(ENCRYPTION_PASSWORD);
        return textEncryptor.decrypt(encryptedText);
    }
}