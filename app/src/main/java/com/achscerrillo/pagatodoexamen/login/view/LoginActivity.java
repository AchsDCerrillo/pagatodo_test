package com.achscerrillo.pagatodoexamen.login.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;

import com.achscerrillo.pagatodoexamen.R;
import com.achscerrillo.pagatodoexamen.login.contracts.LoginPresenterInterface;
import com.achscerrillo.pagatodoexamen.login.contracts.LoginViewInterface;
import com.achscerrillo.pagatodoexamen.login.interactor.LoginInteractor;
import com.achscerrillo.pagatodoexamen.login.presenter.LoginPresenter;
import com.achscerrillo.pagatodoexamen.main.MainActivity;
import com.achscerrillo.pagatodoexamen.persistence.preferences.PreferencesFacade;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private TextInputLayout userLayout;
    private TextInputLayout passwordLayout;
    private TextInputEditText user;
    private TextInputEditText password;
    private ProgressBar progressBar;
    private Button loginButton;

    private LoginPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initReferences();
        uiReferences();
        presenter.onCreate();
    }

    private void initReferences(){
        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    private void uiReferences(){
        userLayout = findViewById(R.id.input_layout_user);
        passwordLayout = findViewById(R.id.input_layout_password);
        user = findViewById(R.id.input_user);
        password = findViewById(R.id.input_password);
        progressBar = findViewById(R.id.progress);
        loginButton = findViewById(R.id.login_button);
    }

    public void onClickLogin(View view){
        presenter.validate(user.getText().toString().trim(), password.getText().toString().trim());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorUserName() {
        userLayout.setError(getString(R.string.bad_name));
    }

    @Override
    public void showErrorPassword() {
        passwordLayout.setError(getString(R.string.bad_pass));
    }

    @Override
    public void showError(int errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(errorMessage)
                .setTitle(R.string.app_name)
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        dialogInterface.cancel();
                    }
                });
        final AlertDialog alertDialog = builder.create();

        alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alertDialog
                        .getButton(AlertDialog.BUTTON_POSITIVE)
                        .setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
            }
        });
        alertDialog.show();
    }

    @Override
    public void resetUserName() {
        user.setText("");
        user.clearFocus();
        userLayout.setError(null);
    }

    @Override
    public void resetPassword() {
        password.setText("");
        password.clearFocus();
        passwordLayout.setError(null);
    }

    @Override
    public void disabelButton() {
        loginButton.setEnabled(false);
    }

    @Override
    public void enableButton() {
        loginButton.setEnabled(true);
    }

    @Override
    public void goMainView() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void saveData(String agent, String id, String token) {
        PreferencesFacade preferencesFacade = PreferencesFacade.getInstance(getApplicationContext());
        preferencesFacade.saveAgent(agent);
        preferencesFacade.saveToken(token);
        preferencesFacade.saveUserId(id);

        Log.i("data", "token: " + preferencesFacade.getToken());
    }

    @Override
    public void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
