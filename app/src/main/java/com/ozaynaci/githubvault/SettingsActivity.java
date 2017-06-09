package com.ozaynaci.githubvault;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ozaynaci.githubvault.constants.Constants;
import com.ozaynaci.githubvault.network.Utils;

/**
 * Created by Ozaynaci on 27/05/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    Activity activity;
    User user;
    private EditText username_settings;
    private EditText password_settings;
    private EditText password_confirm_settings;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        activity = this;
        user = new User(activity);
        username_settings = (EditText) findViewById(R.id.input_username_settings);
        password_settings = (EditText) findViewById(R.id.input_password_settings);
        password_confirm_settings = (EditText) findViewById(R.id.input_password_confirm_settings);
        btn_save = (Button)findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btn_save) {
                    // Handle clicks for btnChangePassword
                    if (user.getString(Constants.login_name).equals("Github@example.com")) {
                        if (Utils.isEmpty(password_settings)) {
                            Toast.makeText(SettingsActivity.this, "Oops! enter New Password.", Toast.LENGTH_LONG).show();
                        } else if (Utils.isEmpty(password_confirm_settings)) {
                            Toast.makeText(SettingsActivity.this, "Oops! enter Confirm Password", Toast.LENGTH_LONG).show();
                        } else if (!password_settings.getText().toString().equals(password_confirm_settings.getText().toString())) {
                            Toast.makeText(SettingsActivity.this, "Oops! Passwords do not match", Toast.LENGTH_LONG).show();
                        } else {
                            user.setString(Constants.password, password_settings.getText().toString());
                            user.setString(Constants.login_name, "Github@example.com");
                            Toast.makeText(SettingsActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(SettingsActivity.this, "Oops! Email address invalid", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
