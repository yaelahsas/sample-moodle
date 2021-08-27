package com.example.moodle.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {

    public static final String key_id = "keyid";
    public static final String key_nama = "keynama";
    public static final String key_token = "keytoken";
    private static final String pref_name = "moodle";
    private static final String is_login = "islogin";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(pref_name, mode);
        editor = pref.edit();
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    //

    public static void setid(Context context, String idku) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key_id, idku);
        editor.apply();
    }

    public static void setKey_token(Context context, String token) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key_token, token);
        editor.apply();
    }

    public static void setLogin(Context context, boolean idLogin) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(is_login, idLogin);
        editor.apply();
    }

    public static boolean is_login(Context context) {
        return getSharedPreference(context).getBoolean(is_login, false);
    }

    public static String getKey_token(Context context) {
        return getSharedPreference(context).getString(key_token, "");
    }

    public static String getId(Context context) {
        return getSharedPreference(context).getString(key_id, "");
    }


    public static void setKey_nama(Context context, String nama) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key_nama, nama);
        editor.apply();
    }

    public static String getKey_nama(Context context) {
        return getSharedPreference(context).getString(key_nama, "");
    }


    //


}
