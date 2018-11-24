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
        BackendAPI service = retrofit.create(BackendAPI.class);
        return service.cadastrarUsuario(cliente);
    }

    public static List<Truck> converterParaCliente(Response<List<Truck>> lista){
        List<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < lista.body().size(); i++){
            trucks.add(new Truck(
                    lista.body().get(i).getId(),
                    lista.body().get(i).getNome(),
                    lista.body().get(i).getImg()
            ));
        }
        return trucks;
    }
}
