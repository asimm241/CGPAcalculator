package com.example.asimm.cgpa_calculator.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asimm on 10/15/2017.
 */

public class Utilities {

    private static final String PREF_APP = "CGPA_APP_PREF";
    private static final String IS_LOGIN = "is_login";
    private static final String PREF_CGPA = "CGPA";
    private static final String PREF_UNI = "PREF_UNI";
    private static SharedPreferences mSharedPref;

    public static void  inIt(Context context){
        mSharedPref = context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE);
    }

    public static void  saveCGPA(float cgpa){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putFloat(PREF_CGPA, cgpa);
    }

    public static void getCGPA(){
        mSharedPref.getFloat(PREF_CGPA, 0);
    }

    public static void saveUniversity(String u){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PREF_UNI, u);
    }

    public static boolean getIsLogin() {
        return mSharedPref.getBoolean(IS_LOGIN, false);
    }

    public static void setIsLogin(boolean isLogin) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(IS_LOGIN, isLogin);
    }
}
