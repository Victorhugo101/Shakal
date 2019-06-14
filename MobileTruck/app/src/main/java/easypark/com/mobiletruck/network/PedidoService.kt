package easypark.com.mobiletruck.network

import easypark.com.mobiletruck.model.PedidoOverviewDTO
import easypark.com.mobiletruck.session.BackendRetrofitBuilder
import retrofit2.Call

class PedidoService {


    fun listarPedidos(): Call<List<PedidoOverviewDTO>> {
        var instance = BackendRetrofitBuilder.instance.backendAPI
        return instance.lisarPedidos()
    }

    companion object {
        fun newInstance() = PedidoService()
    }
}