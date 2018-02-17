package com.achscerrillo.pagatodoexamen.webservices;

import com.achscerrillo.pagatodoexamen.login.entity.web.LoginRequest;
import com.achscerrillo.pagatodoexamen.login.entity.web.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public interface PagaTodo {
    @Headers({
            "Content-Type: application/json",
            "SO: Android",
            "Version: 2.5.2"
    })
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
