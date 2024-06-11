package com.example.postaldelivery.util;

import java.math.BigInteger;

public class Validator {
    public boolean validateAadharNumber(String aadharNumber) {
        boolean valid = true;
        valid = valid && aadharNumber.length() == 12;
        try{
            new BigInteger(aadharNumber);
        } catch (NumberFormatException e){
            valid = false;
        }
        return valid && aadharNumber.charAt(0) != '0';
    }
    public boolean validateName(String name){
        return name.matches("[a-zA-Z]+") && name.length() >= 3;
    }
    public boolean validateCity(String city){
        return city.matches("[a-zA-Z]+") && city.length() >= 2;
    }
    public boolean validatePincode(String pincode){
        return pincode.matches("[0-9]+") && pincode.length() == 6;
    }
    public boolean validateAddress(String address){
        return address.length() >= 3 && address.length() <= 100 && address.matches("[a-zA-Z0-9, -]+");
    }
}
