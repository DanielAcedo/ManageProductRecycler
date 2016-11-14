package com.danielacedo.manageproductrecycler.model;

/**
 * Created by Daniel on 14/11/16.
 */

public class Error {
    public static final int OK = 0; // Success
    public static final int PASSWORD_DIGIT = 10; //The password doesn't comply with the password minimum digit policy
    public static final int PASSWORD_UPPERLOWERCASE = 11; //The password doesn't comply with the password minimum lowercase/uppercase policy
    public static final int PASSWORD_LENGTH = 12; //The password doesn't comply with the password length policy
    public static final int DATA_EMPTY = 13; //The user or password field is empty
    public static final int EMAIL_INVALID = 14;
    public static final int PASSWORD_MISMATCH = 15;
    public static final int EMAIL_MISMATCH = 16;
    public static final int COMPANYNAME_EMPTY = 17;

    public static int code;
    public static String message;
    static{

    }
}
