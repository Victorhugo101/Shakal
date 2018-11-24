package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Categoria;
import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.beans.PedidoDTO;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.Truck;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Renilson Albuquerque on 21/11/2018.
 */

public interface BackendAPI {


    @Headers("Content-Type: application/json")
    @GET("/categoria/listar")
    Call<List<Categoria>> listarCategorias();

    @Headers("Content-Type: application/json")
    @GET("/produto/categoria/{id}")
    Call<List<Produto>> listarProdutosPorCategoria(@Path("id") Long id);

    @Headers("Content-Type: application/json")
    @GET("/produto/truck/{id}")
    Call<List<Produto>> listarProdutosPorTruck(@Path("id") Long id);

    @Headers("Content-Type: application/json")
    @GET("/truck/listar/mesa/{id}")
    Call<List<Truck>> listarTrucksPorMesa(@Path("id") Long id);

    @Headers("Content-Type: application/json")
    @POST("/usuario/cadastrar")
    Call<Boolean> cadastrarUsuario(@Body Cliente cliente);

    @Headers("Content-Type: application/json")
    @POST("/usuario/logar")
    Call<Boolean> logarUsuario(@Body LoginDTO login);

    @Headers("Content-Type: application/json")
    @POST("/pedido/save")
    Call<Boolean> cadastrarPedido(@Body PedidoDTO pedidoDTO);
}
