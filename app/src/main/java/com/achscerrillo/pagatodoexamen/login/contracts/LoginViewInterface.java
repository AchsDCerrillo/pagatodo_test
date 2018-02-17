package com.achscerrillo.pagatodoexamen.login.contracts;

import android.support.annotation.StringRes;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public interface LoginViewInterface {

    void showProgress();
    void hideProgress();
    void showErrorUserName();
    void showErrorPassword();
    void showError(@StringRes int errorMessage);
    void resetUserName();
    void resetPassword();
    void disabelButton();
    void enableButton();
    void goMainView();
    void saveData(String agent, String id, String token);
    void closeKeyBoard();
}
