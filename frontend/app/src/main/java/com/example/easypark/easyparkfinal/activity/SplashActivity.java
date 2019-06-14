package com.example.easypark.easyparkfinal.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.session.SessionManager;
import com.example.easypark.easyparkfinal.utils.Constants;

public class SplashActivity extends AppCompatActivity {


    private Handler handler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();

        initializeSession();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!SessionManager.getInstance().getSession().isLoggedIn()){
                    goToLoginScreen();
                }
                else{
                    goToQrCodeScreen();
                }
            }
        }, Constants.SPLASH_TIME);
    }
    private void initializeSession(){
        SessionManager.getInstance().createSession(getSharedPreferences("usuario", MODE_PRIVATE));
    }

    private void goToLoginScreen(){
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
    private void goToQrCodeScreen(){
        Intent myIntent = new Intent(this, ValidationActivity.class);
        startActivity(myIntent);
    }




}
