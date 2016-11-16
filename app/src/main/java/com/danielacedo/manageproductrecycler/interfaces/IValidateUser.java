package com.danielacedo.manageproductrecycler.interfaces;

import android.content.Context;
import android.util.Patterns;

import com.danielacedo.manageproductrecycler.R;
import com.danielacedo.manageproductrecycler.model.Error;

/**
 * Created by usuario on 11/11/16.
 */

public interface IValidateUser extends IValidateAccount {

    int EMAIL_INVALID = 14;

    interface PresenterUser{
        static int validateCredentialsEmail(String email){

            int code = Error.OK;

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                code = Error.EMAIL_INVALID;
            }

            return code;
        }

        static int validateCredentialsConfirmEmail(String email, String confirmEmail){
            int code = Error.OK;

            if(!email.equals(confirmEmail)){
                code = Error.EMAIL_MISMATCH;
            }

            return code;
        }

        static int validateCredentialsConfirmPassword(String pass, String confirmPassword){
            int code = Error.OK;

            if(!pass.equals(confirmPassword)){
                code = Error.PASSWORD_MISMATCH;
            }

            return code;
        }

        static int validateCredentialsCompanyName(String companyName, boolean isCompany){
            int code = Error.OK;

            if(isCompany && companyName.equals("")) {
                code = Error.COMPANYNAME_EMPTY;
            }

            return code;
        }

        void validateCredentials(String user, String password, String confirmPassword, String email,
                                 String confirmEmail, String companyname, boolean isCompany);

    }
}
