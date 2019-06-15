package easypark.com.mobiletruck.parcelables

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PedidoDetalheParcelable(val id: Int, val nomeCliente: String, val mesa: Int,
                              val status: String, val produtos: ListProdutoPedido): Parcelable {
}