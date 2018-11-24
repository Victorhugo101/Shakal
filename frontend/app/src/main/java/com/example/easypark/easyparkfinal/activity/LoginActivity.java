package com.example.easypark.easyparkfinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.network.ClienteService;
import com.example.easypark.easyparkfinal.network.UsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnCadastro;
    private EditText txtLogin;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setBtnCadastro();

            }
        });

    }

    private void validate(){
        LoginDTO login = new LoginDTO(txtLogin.getText().toString(), txtPassword.getText().toString());
        Call call = UsuarioService.logarUsuario(login);
        call.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()==true){
                    goToQrCode();
                }else exibirMensagem("E-mail ou senha inválido!");

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                exibirMensagem("Erro teste");
            }

        });

    }
    private void setBtnCadastro(){
        txtLogin.setText("");
        txtPassword.setText("");
        Intent myIntent = new Intent(this, CadastroActivity.class);
        startActivity(myIntent);
    }
      public void exibirMensagem(String mensagem){
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show();
        }
        private void goToQrCode(){
            Intent myIntent = new Intent(this, ValidationActivity.class);
            startActivity(myIntent);
}
}