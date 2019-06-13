package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.session.RetrofitBuilder;
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

public class ProdutoService {


    public static Call<List<Produto>> listarProdutosPorTruck(long truckID){
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IBackendAPI service = retrofit.create(IBackendAPI.class);
        */
        return RetrofitBuilder.getApiService().listarProdutosPorTruck(truckID);
    }

    public static List<Produto> converterParaProduto(Response<List<Produto>> lista){
        List<Produto> produtos = new ArrayList<>();
        for (int i = 0; i < lista.body().size(); i++){
            produtos.add(new Produto(
                    lista.body().get(i).getId(),
                    lista.body().get(i).getNome(),
                    lista.body().get(i).getValor()
            ));
        }
        return produtos;
    }
}
