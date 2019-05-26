package easypark.com.mobiletruck.model

import java.io.Serializable

class PedidoOverviewDTO(val id: Int, val nomeCliente: String, val mesa: Int, val status: PedidoStatusEnum): Serializable {
}