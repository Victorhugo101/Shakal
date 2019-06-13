package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.beans.TokenDTO;
import com.example.easypark.easyparkfinal.utils.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioService {
    public static Call<TokenDTO> logarUsuario(LoginDTO login){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IBackendAPI service = retrofit.create(IBackendAPI.class);
        return service.logarUsuario(login);
    }
}
