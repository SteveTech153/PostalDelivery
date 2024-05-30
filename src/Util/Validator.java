package Util;

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
}
