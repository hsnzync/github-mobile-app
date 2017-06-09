package com.ozaynaci.githubvault.models;

/**
 * Created by Ozaynaci on 23/05/2017.
 */

public class ApiHandler {
    private String name;
    private String language;
    private String created_at;
    private String default_branch;
    private ApiResults owner;

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getCreated_at() {
        return created_at;
    }

    public ApiResults getOwner() {
        return owner;
    }

    public String getDefault_branch() {
        return default_branch;
    }
}
