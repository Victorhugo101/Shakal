package com.example.easypark.easyparkfinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.easypark.easyparkfinal.R;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtNomeCadastro;
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrar= (Button)findViewById(R.id.btnCadastrar);
        txtNomeCadastro = (EditText)findViewById(R.id.txtNomeCadastro);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

            }
        });

    }

    private void validate(){
        txtNomeCadastro.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
}

