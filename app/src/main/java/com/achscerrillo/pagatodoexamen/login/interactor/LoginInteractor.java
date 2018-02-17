package com.achscerrillo.pagatodoexamen.login.interactor;

import com.achscerrillo.pagatodoexamen.R;
import com.achscerrillo.pagatodoexamen.login.contracts.LoginInteractorInterface;
import com.achscerrillo.pagatodoexamen.login.entity.web.LoginRequest;
import com.achscerrillo.pagatodoexamen.login.entity.web.LoginResponse;
import com.achscerrillo.pagatodoexamen.login.entity.web.User;
import com.achscerrillo.pagatodoexamen.webservices.PagaTodoWS;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class LoginInteractor implements LoginInteractorInterface {
    private LoginInteractorOuterInterface presenter;


    @Override
    public void setPresenter(LoginInteractorOuterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(String userName, String password) {
        User user = new User();
        user.setPass(password);
        user.setUser(userName);
        LoginRequest request = new LoginRequest();
        request.setData(user);
        PagaTodoWS.getInstance().getPagaTodo().login(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.code() == 200 && loginResponse != null && loginResponse.getError() == null){
                    presenter.onLoginSuccess(response.body());
                }else {
                    presenter.onLoginError(R.string.bad_credentials);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                presenter.onLoginError(R.string.internet_connection);
            }
        });
    }
}
