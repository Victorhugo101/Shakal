package easypark.com.mobiletruck.network

import easypark.com.mobiletruck.model.PedidoDetalhe
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import easypark.com.mobiletruck.session.BackendRetrofitBuilder
import retrofit2.Call

class PedidoService {


    fun listarPedidos(id: Long): Call<List<PedidoOverviewDTO>> {
        var instance = BackendRetrofitBuilder.instance.backendAPI
        return instance.lisarPedidos(id)
    }

    fun detalharPedidos(id: Long): Call<PedidoDetalhe> {
        var instance = BackendRetrofitBuilder.instance.backendAPI
        return instance.detalharPedido(id)
    }

    fun finalizarPedido(id: Long): Call<Boolean> {
        var instance = BackendRetrofitBuilder.instance.backendAPI
        return instance.finalizarPedido(id)
    }

    companion object {
        fun newInstance() = PedidoService()
    }
}