package com.example.postaldelivery.system.service;

import com.example.postaldelivery.system.actions.PasswordActions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordService implements PasswordActions {
    private static final byte[] salt = new byte[]{(byte)(-81-4212640-52-6014-611110811-6121-13810)};
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    public boolean checkPassword(String originalPassword, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedOriginalPassword = hashPassword(originalPassword);
        return hashedOriginalPassword.equals(hashedPassword);
    }
}
