package com.example.easypark.easyparkfinal.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.utils.Constants;

public class SplashActivity extends AppCompatActivity {


    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNextScreen();
            }
        }, Constants.SPLASH_TIME);
    }

    private void goToNextScreen(){
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
}
