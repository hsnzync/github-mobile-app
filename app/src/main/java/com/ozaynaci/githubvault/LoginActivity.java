package com.ozaynaci.githubvault;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ozaynaci.githubvault.constants.Constants;
import com.ozaynaci.githubvault.network.Utils;

/**
 * Created by Ozaynaci on 24/05/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Activity activity;
    User user;

    private EditText username;
    private EditText password;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity = this;
        user = new User(activity);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        login_btn = (Button) findViewById(R.id.btn_login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == login_btn) {
                    if (Utils.isEmpty(username)) {
                        Toast.makeText(LoginActivity.this, "Oops! enter E-mail address", Toast.LENGTH_LONG).show();
                    } else if (Utils.isEmpty(password)) {
                        Toast.makeText(LoginActivity.this, "Oops! enter Password", Toast.LENGTH_LONG).show();
                    } else {
                        if (user.getString(Constants.login_name).equals("")) {
                            if ("Github@example.com".equals(username.getText().toString()) &&
                                            "0000".equals(password.getText().toString()))
                            {
                                startActivity(new Intent(activity, SearchActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Oops! Username or password incorrect", Toast.LENGTH_LONG).show();
                            }

                        } else if (user.getString(Constants.login_name).equals(username.getText().toString()) &&
                                user.getString(Constants.password).equals(password.getText().toString())) {
                            startActivity(new Intent(activity, SearchActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Oops! Username or password incorrect", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}
