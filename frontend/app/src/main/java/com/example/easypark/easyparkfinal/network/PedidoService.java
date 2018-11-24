package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Pedido;
import com.example.easypark.easyparkfinal.beans.PedidoDTO;
import com.example.easypark.easyparkfinal.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoService {


    public static Call<Boolean> cadastrarPedido(PedidoDTO pedidoDTO){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BackendAPI service = retrofit.create(BackendAPI.class);
        return service.cadastrarPedido(pedidoDTO);
    }
    /*
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
    */
}
