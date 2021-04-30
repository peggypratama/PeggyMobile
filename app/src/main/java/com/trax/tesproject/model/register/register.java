package com.trax.tesproject.model.register;

import com.google.gson.annotations.SerializedName;

public class register {
    @SerializedName("email")
    private String email;
    @SerializedName("passsword")
    private String pasword;
    @SerializedName("username")
    private String username;

    @Override
    public String toString() {
        return "register{" +
                "email='" + email + '\'' +
                ", pasword='" + pasword + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
