package com.example.postaldelivery.system.actions;
import java.security.NoSuchAlgorithmException;

public interface PasswordActions {
    String hashPassword(String password) throws NoSuchAlgorithmException;
    boolean checkPassword(String originalPassword, String hashedPassword) throws NoSuchAlgorithmException;
}

