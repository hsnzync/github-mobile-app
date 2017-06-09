package com.ozaynaci.githubvault.models;

/**
 * Created by Ozaynaci on 24/05/2017.
 */

public class ApiResults {
    private String avatar_url;
    private String login;

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
