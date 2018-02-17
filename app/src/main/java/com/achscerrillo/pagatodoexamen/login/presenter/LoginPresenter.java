package com.achscerrillo.pagatodoexamen.login.presenter;

import android.support.annotation.StringRes;

import com.achscerrillo.pagatodoexamen.login.contracts.LoginInteractorInterface;
import com.achscerrillo.pagatodoexamen.login.contracts.LoginPresenterInterface;
import com.achscerrillo.pagatodoexamen.login.contracts.LoginViewInterface;
import com.achscerrillo.pagatodoexamen.login.entity.web.LoginResponse;
import com.achscerrillo.pagatodoexamen.login.route.LoginRoute;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class LoginPresenter implements LoginPresenterInterface, LoginInteractorInterface.LoginInteractorOuterInterface {
    LoginViewInterface view;
    LoginInteractorInterface interactor;

    public LoginPresenter(LoginViewInterface view, LoginInteractorInterface interactor) {
        this.view = view;
        this.interactor = interactor;
        this.interactor.setPresenter(this);
    }

    @Override
    public void onCreate() {
        view.hideProgress();
        view.resetUserName();
        view.resetPassword();
        view.enableButton();
    }

    @Override
    public void validate(String user, String password) {
        if (user == null || user.isEmpty()){
            view.showErrorUserName();
            return;
        }

        if (password == null || password.isEmpty()){
            view.showErrorPassword();
            return;
        }
        view.closeKeyBoard();
        view.disabelButton();
        view.showProgress();
        interactor.login(user, password);
    }

    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        view.enableButton();
        view.hideProgress();
        view.saveData(loginResponse.getAgente(), loginResponse.getId_user(), loginResponse.getToken());
        LoginRoute.goMainView(view);
    }

    @Override
    public void onLoginError(@StringRes int message) {
        view.enableButton();
        view.hideProgress();
        view.showError(message);
    }
}
