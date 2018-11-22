package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Renilson Albuquerque on 21/11/2018.
 */

public class TruckService {


    public static Call<List<Truck>> listarTrcksPerto(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BackendAPI service = retrofit.create(BackendAPI.class);
        return service.listarTrucksPorMesa(1L);
    }

    public static List<Truck> converterParaTruck(Response<List<Truck>> lista){
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
