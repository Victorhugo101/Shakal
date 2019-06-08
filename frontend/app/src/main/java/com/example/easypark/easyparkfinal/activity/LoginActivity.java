package com.example.easypark.easyparkfinal.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.beans.TokenDTO;
import com.example.easypark.easyparkfinal.network.ClienteService;
import com.example.easypark.easyparkfinal.network.UsuarioService;
import com.example.easypark.easyparkfinal.utils.Constants;

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

            this.showIPDialog();

    }

    private void validate(){
        LoginDTO login = new LoginDTO(txtLogin.getText().toString(), txtPassword.getText().toString());
        Call call = UsuarioService.logarUsuario(login);
        call.enqueue(new Callback<TokenDTO>() {

            @Override
            public void onResponse(Call<TokenDTO> call, Response<TokenDTO> response) {
                if(response.code() == 200){

                    SharedPreferences sp = getSharedPreferences("usuario", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    //ed.putInt("id", response.body().getId().intValue());
                    //ed.putString("nome", response.body().getNome());
                    //ed.putString("email", response.body().getEmail());
                    ed.putString("token", response.body().getToken());

                    ed.commit();
                    goToQrCode();
                }
                else exibirMensagem("E-mail ou senha inválido!");

            }

            @Override
            public void onFailure(Call<TokenDTO> call, Throwable t) {
                exibirMensagem("Erro ao conectar com o servidor");
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
    public void showIPDialog(){
        final EditText txtIP = new EditText(this);


        new AlertDialog.Builder(this)
                .setTitle("Digite o IP do servidor:")
                .setView(txtIP)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Constants.BASE_URL = "http://" + txtIP.getText().toString() + ":9000";
                    }
                })/*
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })*/
                .show();
    }
}