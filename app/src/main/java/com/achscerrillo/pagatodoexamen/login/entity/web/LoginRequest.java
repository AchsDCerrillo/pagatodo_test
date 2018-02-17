package com.achscerrillo.pagatodoexamen.login.entity.web;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class LoginRequest {
    User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "data=" + data +
                '}';
    }
}
