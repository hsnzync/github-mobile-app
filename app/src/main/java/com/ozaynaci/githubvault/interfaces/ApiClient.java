package com.ozaynaci.githubvault.interfaces;

import com.ozaynaci.githubvault.models.ApiHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ozaynaci on 23/05/2017.
 */

public interface ApiClient {

    @GET("/users/{user}/repos")
    Call<List<ApiHandler>> reposForUser(@Path("user") String user);
}
