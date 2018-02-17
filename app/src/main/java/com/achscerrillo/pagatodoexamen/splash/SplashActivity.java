package com.achscerrillo.pagatodoexamen.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.achscerrillo.pagatodoexamen.R;
import com.achscerrillo.pagatodoexamen.login.route.LoginRoute;

public class SplashActivity extends AppCompatActivity {
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initUIReferences();
        ui();
    }

    private void initUIReferences(){
        logo = findViewById(R.id.splash_logo);
    }

    private void ui(){
        logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginRoute.createModule(getApplicationContext()));
                finish();
            }
        }, 500);
    }
}
