package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.utils.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioService {
    public static Call<Cliente> logarUsuario(LoginDTO login){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BackendAPI service = retrofit.create(BackendAPI.class);
        return service.logarUsuario(login);
    }
}
