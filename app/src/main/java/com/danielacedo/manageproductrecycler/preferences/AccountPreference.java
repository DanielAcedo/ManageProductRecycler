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
    private static Context context;

    public static final String FILE = "com.danielacedo.manageproductrecycler_preferences";

    public static final String USER = "user";
    public static final String PASSWORD = "password";


    private AccountPreference(){

    }

    //Singleton
    public static IPreferences getInstance(Context con){
        if(instance == null){
            instance = new AccountPreference();
            context = con;
        }

        return instance;
    }

    public static void putUser(String user){
        //getEditor().putString(USER, user);
    }

    /*
    //TODO To be implemented
    private static SharedPreferences.Editor getEditor(){

    }*/
}
