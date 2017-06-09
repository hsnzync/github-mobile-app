package com.ozaynaci.githubvault;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.ozaynaci.githubvault.network.Locationhandler;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.ozaynaci.githubvault.R.id.lblLocation;

public class LocationActivity extends AppCompatActivity {

    // UI elements
    private Button btnShowLocation;
    private TextView lblLocation;
    Locationhandler loc_handler;

    private double latitude;
    private double longitude;
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        lblLocation = (TextView) findViewById(R.id.lblLocation);

        loc_handler = new Locationhandler(this);

        // Show location button click listener
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call displayLocation from network/Locationhandler to show lattitude + longitude in lblLocation textview
            }
        });
    }

}