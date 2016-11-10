package com.danielacedo.manageproductrecycler.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.danielacedo.manageproductrecycler.interfaces.IPreferences;

/**
 * Created by Daniel on 10/11/16.
 */

public class AccountPreference implements IPreferences{

    private static AccountPreference instance;
    private Context context;

    public static final String FILE = "com.danielacedo.manageproductrecycler_preferences";

    public static final String USER = "user";
    public static final String PASSWORD = "password";


    private AccountPreference(Context con){
        context = con;
    }

    //Singleton
    public static AccountPreference getInstance(Context con){
        if(instance == null){
            instance = new AccountPreference(con);
        }

        return instance;
    }

    public void putUser(String user){
        getEditor().putString(USER, user).apply();
    }

    public void putPassword(String password){
        getEditor().putString(PASSWORD, password).apply();
    }

    public String readUser(){
        return getSharedPreferences().getString(USER, "");
    }

    public String readPassword(){
        return getSharedPreferences().getString(PASSWORD, "");
    }

    private SharedPreferences getSharedPreferences(){
        return context.getSharedPreferences(FILE, IPreferences.MODE);
    }

    private SharedPreferences.Editor getEditor(){
        return getSharedPreferences().edit();
    }
}
