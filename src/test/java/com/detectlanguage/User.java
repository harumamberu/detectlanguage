package com.detectlanguage;

public class User {
    private String api_token;

    public User() {
        this.api_token = "d5c34e4df1f95cf94063141ca177f339";
    }
    public User(String api_token) {
        this.api_token = api_token;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
