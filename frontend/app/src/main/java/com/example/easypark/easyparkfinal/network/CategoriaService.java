package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Categoria;
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

public class CategoriaService {



    public static Call<List<Categoria>> listarCategorias(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BackendAPI service = retrofit.create(BackendAPI.class);
        return service.listarCategorias();
    }

    public static List<Categoria> converterParaCategoria(Response<List<Categoria>> lista){
        List<Categoria> categorias = new ArrayList<>();
        for (int i = 0; i < lista.body().size(); i++){
            categorias.add(new Categoria(
                    lista.body().get(i).getId(),
                    lista.body().get(i).getNome()
            ));
        }
        return categorias;
    }
}
