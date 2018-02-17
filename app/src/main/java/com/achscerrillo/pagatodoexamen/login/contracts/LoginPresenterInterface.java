package com.achscerrillo.pagatodoexamen.login.contracts;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public interface LoginPresenterInterface {
    void onCreate();
    void validate(String user, String password);
}
