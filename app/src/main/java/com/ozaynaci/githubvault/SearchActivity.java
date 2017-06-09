package com.ozaynaci.githubvault;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ozaynaci on 24/05/2017.
 */

public class SearchActivity extends AppCompatActivity {

    private EditText namefield;
    private Button searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toast.makeText(SearchActivity.this, "Login successful", Toast.LENGTH_LONG).show();

        namefield = (EditText) findViewById(R.id.input_search);
        searchbtn = (Button) findViewById(R.id.btn_search);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = namefield.getText().toString();
                searchName(name);
            }
        });
    }

    private void searchName(String name) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
