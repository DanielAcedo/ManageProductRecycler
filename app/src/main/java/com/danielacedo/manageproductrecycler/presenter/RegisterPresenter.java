package com.danielacedo.manageproductrecycler.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.danielacedo.manageproductrecycler.R;
import com.danielacedo.manageproductrecycler.interfaces.IRegisterMvp;
import com.danielacedo.manageproductrecycler.interfaces.IValidateAccount;
import com.danielacedo.manageproductrecycler.interfaces.IValidateUser;
import com.danielacedo.manageproductrecycler.model.Error;
import com.danielacedo.manageproductrecycler.preferences.AccountPreference;

import java.util.regex.Pattern;

;

/**
 * Created by Daniel on 10/11/16.
 */

public class RegisterPresenter implements IValidateUser.Presenter{

    IValidateUser.View view;

    public RegisterPresenter(IValidateUser.View view){
        this.view = view;
    }

    @Override
    public void validateCredentialsRegister(String user, String pass, String confirmPass, String email, String confirmEmail, String companyName, boolean isCompany) {

        int validateUser = IValidateAccount.Presenter.validateCredentialsUser(user);
        int validatePassword = IValidateAccount.Presenter.validateCredentialsPassword(pass);
        int validateConfirmPassword = IValidateUser.Presenter.validateCredentialsConfirmPassword(pass, confirmPass);
        int validateEmail = IValidateUser.Presenter.validateCredentialsEmail(email);
        int validateConfirmEmail = IValidateUser.Presenter.validateCredentialsConfirmEmail(email, confirmEmail);
        int validateCompanyName = IValidateUser.Presenter.validateCredentialsCompanyName(companyName, isCompany);

        //TODO FINISH THIS MESS


        else{
            AccountPreference accountPreference = AccountPreference.getInstance((Context)view);
            accountPreference.putUser(user);
            accountPreference.putPassword(pass);

            Toast.makeText((Context)view, R.string.Toast_SuccessfulRegister, Toast.LENGTH_SHORT).show();
            ((Activity)view).finish();
        }
    }
}
