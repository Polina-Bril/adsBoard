package com.epam.first.validator;

public class DataValidator {
    public static boolean isValidLong(String number){
        try {
            Long.parseLong(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
