package easypark.com.mobiletruck.network

import easypark.com.mobiletruck.model.LoginDTO
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import easypark.com.mobiletruck.model.Token
import retrofit2.Call
import retrofit2.http.*


interface BackendAPI {

    @POST("/login")
    fun logarUsuario(@Body login: LoginDTO): Call<Token>


    @GET("/pedido/listar/truck/{id}")
    fun list() : Call<PedidoOverviewDTO>

/*
    @Headers("Content-Type: application/json")
    @GET("/produto/categoria/{id}")
    fun listarProdutosPorCategoria(@Path("id") id: Long?): Call<List<Produto>>

    @Headers("Content-Type: application/json")
    @GET("/produto/truck/{id}")
    fun listarProdutosPorTruck(@Path("id") id: Long?): Call<List<Produto>>

    @Headers("Content-Type: application/json")
    @GET("/truck/listar/mesa/{id}")
    fun listarTrucksPorMesa(@Path("id") id: Long?): Call<List<Truck>>

    @Headers("Content-Type: application/json")
    @POST("/usuario/cadastrar")
    fun cadastrarUsuario(@Body cliente: Cliente): Call<Boolean>



    @Headers("Content-Type: application/json")
    @POST("/pedido/save")
    fun cadastrarPedido(@Body pedidoDTO: PedidoDTO): Call<Boolean>

    @Headers("Content-Type: application/json")
    @GET("/pedido/listar/{id}")
    fun listarMeusPedidos(@Path("id") id: Long?): Call<List<PedidoListView>>
    */
}