package com.epam.first.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
    private static final String ENCRYPTOR_ALGORITHM = "SHA-1";

    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(ENCRYPTOR_ALGORITHM);
        messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] bytesEncoded = messageDigest.digest();
        BigInteger bigInteger = new BigInteger(1,bytesEncoded);
        String encPassword = bigInteger.toString(16);
        return encPassword;
    }
}
