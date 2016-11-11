package com.danielacedo.manageproductrecycler.interfaces;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.text.TextUtils;

import com.danielacedo.manageproductrecycler.ListProduct_Application;
import com.danielacedo.manageproductrecycler.Product_Activity;
import com.danielacedo.manageproductrecycler.R;
import com.danielacedo.manageproductrecycler.model.User;

import java.util.regex.Pattern;

/**
 * Created by Daniel on 11/11/16.
 */

public interface IValidateAccount {
    int OK = 0; // Success
    int PASSWORD_DIGIT = 10; //The password doesn't comply with the password minimum digit policy
    int PASSWORD_UPPERLOWERCASE = 11; //The password doesn't comply with the password minimum lowercase/uppercase policy
    int PASSWORD_LENGTH = 12; //The password doesn't comply with the password length policy
    int DATA_EMPTY = 13; //The user or password field is empty

    /**
     * Interface to be implemented by the view in the pattern
     * @author Daniel Acedo Calderón
     */
    interface View{
        /**
         * Sends an order to the view to display a message error
         * @param messageError The message to be displayed
         * @author Daniel Acedo Calderón
         */
        void setMessageError(String messageError, int view);
    }

    /**
     * Interface to be implemented by the presenter in the pattern
     */
    interface Presenter{

        void validateCredentialsLogin(String user, String pass);

        static int validateCredentialsUser(String user){

            if(TextUtils.isEmpty(user)) {
                return DATA_EMPTY;
            }

            return OK;

        }

        static int validateCredentialsPassword(String pass){

            int code = OK;

            if(TextUtils.isEmpty(pass)){
                code = DATA_EMPTY;
            }
            else if(!Pattern.matches(".*[0-9].*", pass)){
                code = PASSWORD_DIGIT;
            }
            else if(!Pattern.matches(".*[a-z].*",pass) || !Pattern.matches(".*[A-Z].*",pass)){
                code = PASSWORD_UPPERLOWERCASE;
            }
            else if(pass.length()<8){
                code = PASSWORD_LENGTH;
            }

            return code;
        }
    }
}
