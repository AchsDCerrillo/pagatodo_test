package com.achscerrillo.pagatodoexamen.login.route;

import android.content.Context;
import android.content.Intent;

import com.achscerrillo.pagatodoexamen.login.contracts.LoginViewInterface;
import com.achscerrillo.pagatodoexamen.login.view.LoginActivity;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class LoginRoute {
    public static Intent createModule(Context context){
        return new Intent(context, LoginActivity.class);
    }

    public static void goMainView(LoginViewInterface view){
        view.goMainView();
    }
}
