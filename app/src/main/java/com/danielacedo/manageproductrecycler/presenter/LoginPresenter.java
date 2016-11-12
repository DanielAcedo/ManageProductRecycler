package com.danielacedo.manageproductrecycler.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.danielacedo.manageproductrecycler.ListProduct_Application;
import com.danielacedo.manageproductrecycler.Product_Activity;
import com.danielacedo.manageproductrecycler.R;
import com.danielacedo.manageproductrecycler.Register_Activity;
import com.danielacedo.manageproductrecycler.interfaces.ILoginMvp;
import com.danielacedo.manageproductrecycler.interfaces.IValidateAccount;
import com.danielacedo.manageproductrecycler.model.User;

import static com.danielacedo.manageproductrecycler.interfaces.IValidateAccount.Presenter.*;

import java.util.regex.Pattern;

/**
 * Created by Daniel on 6/10/16.
 */

/**
 * Presenter for the login Activity. It handles all the communication with the model and updates the view when necessary
 * @author Daniel Acedo Calderón
 */
public class LoginPresenter implements IValidateAccount.Presenter {

    private IValidateAccount.View view;

    public LoginPresenter(IValidateAccount.View view){
        this.view = view;
    }

    @Override
    public void validateCredentialsLogin(String user, String password) {

        int validateUser = validateCredentialsUser(user);
        int validatePassword = validateCredentialsPassword(password);

        boolean userOk = validateUser == IValidateAccount.OK;
        boolean passOK = validatePassword == IValidateAccount.OK;


        if (!userOk) {
            view.setMessageError(switchErrorsMessage(validateUser), R.id.edt_User);
        }
        if(!passOK){
            view.setMessageError(switchErrorsMessage(validatePassword), R.id.edt_Pass);
        }
        if(userOk && passOK){
            success(user, password);
        }
    }

    public String switchErrorsMessage(int code){

        String message = "";

        switch(code){
            case IValidateAccount.DATA_EMPTY:
                message = ((Context)view).getResources().getString(R.string.err_emptyData);
                break;
            case IValidateAccount.PASSWORD_DIGIT:
                message = ((Context)view).getResources().getString(R.string.err_Password_Digit);
                break;
            case IValidateAccount.PASSWORD_UPPERLOWERCASE:
                message = ((Context)view).getResources().getString(R.string.err_Password_UpperLowerCase);
                break;
            case IValidateAccount.PASSWORD_LENGTH:
                message = ((Context)view).getResources().getString(R.string.err_Password_Length);
                break;
        }

        return message;
    }

    public void success(String user, String pass){
        //Save the user in the Application class
        ((ListProduct_Application)((Context)view).getApplicationContext()).setUser(new User(user, pass));
        Intent intent = new Intent((Context)view, Product_Activity.class);
        ((Context) view).startActivity(intent);
    }

}
