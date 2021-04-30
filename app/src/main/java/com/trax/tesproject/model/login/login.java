package com.trax.tesproject.model.login;

import com.google.gson.annotations.SerializedName;

public class login {
    @SerializedName("passsword")
    private String pasword;
    @SerializedName("username")
    private String username;

    @Override
    public String toString() {
        return "login{" +
                "pasword='" + pasword + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
