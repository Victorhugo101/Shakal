package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.PedidoDTO;
import com.example.easypark.easyparkfinal.beans.PedidoListView;
import com.example.easypark.easyparkfinal.session.RetrofitBuilder;
import com.example.easypark.easyparkfinal.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoService {


    public static Call<Boolean> cadastrarPedido(PedidoDTO pedidoDTO){
        IBackendAPI service = RetrofitBuilder.getApiService();
        return service.cadastrarPedido(pedidoDTO);
    }

    public static Call<List<PedidoListView>> listarMeusPedidos(Long id){

        IBackendAPI service = RetrofitBuilder.getApiService();
        return service.listarMeusPedidos(id);
    }

    public static List<PedidoListView> converterParaPedidoListView(Response<List<PedidoListView>> lista){
        List<PedidoListView> pedidos = new ArrayList<>();
        for (int i = 0; i < lista.body().size(); i++){
            pedidos.add(new PedidoListView(
                    lista.body().get(i).getId(),
                    lista.body().get(i).getNomeTruck(),
                    lista.body().get(i).getStatus()
            ));
        }
        return pedidos;
    }

}
