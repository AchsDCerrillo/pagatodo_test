package com.achscerrillo.pagatodoexamen.login.entity.web;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class User {
    String pass;
    String user;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
