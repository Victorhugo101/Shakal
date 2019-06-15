package easypark.com.mobiletruck.model

import java.io.Serializable


class PedidoDetalhe(val id: Int, val nomeCliente: String, val mesa: Int,
                    val status: String, val produtos: List<ProdutoPedido>): Serializable