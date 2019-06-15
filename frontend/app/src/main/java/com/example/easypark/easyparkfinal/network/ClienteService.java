package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteService {

    public static Call<Boolean> cadastrarCliente(Cliente cliente){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IBackendAPI service = retrofit.create(IBackendAPI.class);
        return service.cadastrarUsuario(cliente);
    }


}
