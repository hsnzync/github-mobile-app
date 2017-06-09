package com.ozaynaci.githubvault;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Interpolator;
import android.widget.ListView;
import android.widget.Toast;

import com.ozaynaci.githubvault.adapters.ApiAdapter;
import com.ozaynaci.githubvault.interfaces.ApiClient;
import com.ozaynaci.githubvault.models.ApiHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ozaynaci on 22/05/2017.
 */

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();

    private ListView listView;
    private MenuView.ItemView item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.pagination_list);
        item = (MenuView.ItemView) findViewById(R.id.action_settings);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Log.d(TAG, name);
        Toast.makeText(MainActivity.this, "Loading the data...", Toast.LENGTH_LONG).show();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ApiClient client = retrofit.create(ApiClient.class);
        Call<List<ApiHandler>> call = client.reposForUser(name);

        call.enqueue(new Callback<List<ApiHandler>>() {
            @Override
            public void onResponse(Call<List<ApiHandler>> call, Response<List<ApiHandler>> response) {
                List<ApiHandler> items = response.body();

                listView.setAdapter(new ApiAdapter(MainActivity.this, items));
            }

            @Override
            public void onFailure(Call<List<ApiHandler>> call, Throwable t) {
                // error
                Toast.makeText(MainActivity.this, "Error, can't load data", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_location:
                Intent intent1 = new Intent(this, LocationActivity.class);
                startActivity(intent1);
        }

        return super.onOptionsItemSelected(item);
    }
}
