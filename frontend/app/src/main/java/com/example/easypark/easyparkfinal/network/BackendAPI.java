package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.Categoria;
import com.example.easypark.easyparkfinal.beans.Cliente;
import com.example.easypark.easyparkfinal.beans.LoginDTO;
import com.example.easypark.easyparkfinal.beans.PedidoDTO;
import com.example.easypark.easyparkfinal.beans.PedidoListView;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.TokenDTO;
import com.example.easypark.easyparkfinal.beans.Truck;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


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
    @POST("/login")
    Call<TokenDTO> logarUsuario(@Body LoginDTO login);

    @Headers("Content-Type: application/json")
    @POST("/pedido/save")
    Call<Boolean> cadastrarPedido(@Body PedidoDTO pedidoDTO);

    @Headers("Content-Type: application/json")
    @GET("/pedido/listar/{id}")
    Call<List<PedidoListView>> listarMeusPedidos(@Path("id") Long id);
}
