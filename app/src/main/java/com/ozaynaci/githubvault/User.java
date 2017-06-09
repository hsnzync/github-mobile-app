package com.ozaynaci.githubvault;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ozaynaci on 27/05/2017.
 */

public class User {

    private SharedPreferences pref = null;
    private Context parentActivity;
    public static String APP_KEY;

    public User(Context context) {
        parentActivity = context;
        APP_KEY = "AppName";
    }

    public void setString(String key, String value) {
        pref = parentActivity.getSharedPreferences(APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        pref = parentActivity.getSharedPreferences(APP_KEY,
                Context.MODE_PRIVATE);
        return pref.getString(key, "");

    }
}
