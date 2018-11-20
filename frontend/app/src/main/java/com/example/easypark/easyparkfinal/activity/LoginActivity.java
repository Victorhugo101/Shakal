package com.example.easypark.easyparkfinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.easypark.easyparkfinal.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText txtLogin;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

            }
        });

    }

    private void validate(){
        txtLogin.setText("");
        txtPassword.setText("");
        Intent myIntent = new Intent(this, ValidationActivity.class);
        startActivity(myIntent);
    }
}