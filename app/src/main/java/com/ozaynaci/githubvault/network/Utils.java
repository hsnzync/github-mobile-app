package com.ozaynaci.githubvault.network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.LocationListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ozaynaci on 27/05/2017.
 */

public class Utils {

    static ProgressDialog progressDialog;

    public static void showProgress(Activity activity) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    public static void showProgress(Activity activity, String message) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public static void dismissProgress() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
        else
            Log.i("Dialog", "already dismissed");
    }

    public static void internetAlert(Activity activity) {
        new AlertDialog.Builder(activity)
                .setMessage("Please check internet connection.")
                .setPositiveButton("Ok", null)
                .create()
                .show();
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    public static boolean isEmpty(View view) {
        if (view instanceof EditText) {
            if (((EditText) view).getText().toString().length() == 0) {
                return true;
            }
        } else if (view instanceof Button) {
            if (((Button) view).getText().toString().length() == 0) {
                return true;
            }
        }
        return false;
    }

}
