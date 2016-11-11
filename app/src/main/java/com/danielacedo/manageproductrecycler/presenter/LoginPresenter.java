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

    private ILoginMvp.View view;

    public LoginPresenter(ILoginMvp.View view){
        this.view = view;
    }

    @Override
    public void validateCredentialsLogin(String user, String password){

        int validateUser = validateCredentialsUser(user);
        int validatePassword = validateCredentialsPassword(password);

        boolean userOk = validateUser == IValidateAccount.OK;
        boolean passOK = validatePassword == IValidateAccount.OK;

        if(userOk && passOK){
            success(user, password);
        }else{
            //TODO Switch errors
        }
    }

    public void success(String user, String pass){
        //Save the user in the Application class
        ((ListProduct_Application)((Context)view).getApplicationContext()).setUser(new User(user, pass));
        Intent intent = new Intent((Context)view, Product_Activity.class);
        ((Context) view).startActivity(intent);
    }

    /**
     * Deals with opening the RegisterActivity and reacts to its results
     * @author Daniel Acedo Calderón
     */
    public void openRegisterActivity() {
        Intent intent = new Intent((Context)view, Register_Activity.class);
        ((Context) view).startActivity(intent);
    }
}
