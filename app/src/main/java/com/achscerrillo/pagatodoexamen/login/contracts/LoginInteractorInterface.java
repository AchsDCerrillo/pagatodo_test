package com.achscerrillo.pagatodoexamen.login.contracts;

import android.support.annotation.StringRes;

import com.achscerrillo.pagatodoexamen.login.entity.web.LoginResponse;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public interface LoginInteractorInterface {
    void login(String userName, String password);
    void setPresenter(LoginInteractorOuterInterface presenter);

    interface LoginInteractorOuterInterface{
        void onLoginSuccess(LoginResponse loginResponse);
        void onLoginError(@StringRes int message);
    }
}
