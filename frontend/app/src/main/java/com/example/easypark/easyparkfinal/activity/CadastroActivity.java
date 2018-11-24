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
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.network.ClienteService;
import com.example.easypark.easyparkfinal.network.TruckService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText txtNomeCadastro;
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        txtNomeCadastro = (EditText) findViewById(R.id.txtNomeCadastro);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

            }
        });

    }

    private void validate() {

        Cliente cliente = new Cliente(0L, txtNomeCadastro.getText().toString()
                , txtEmail.getText().toString(), txtPassword.getText().toString());
        Call call = ClienteService.cadastrarCliente(cliente);
        call.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()==true){
                    exibirMensagem("Usuário cadastrado com sucesso!");
                    backLoginActivity();
                }else exibirMensagem("E-mail ou senha inválido!");

            }


            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                exibirMensagem("Erro teste");
            }

        });
    }
    public void exibirMensagem(String mensagem){
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show();
    }
    private void backLoginActivity(){
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
}
