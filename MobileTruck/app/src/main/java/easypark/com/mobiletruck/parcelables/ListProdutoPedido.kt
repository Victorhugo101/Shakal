package easypark.com.mobiletruck.parcelables

import android.os.Parcelable
import easypark.com.mobiletruck.model.ProdutoPedido
import kotlinx.android.parcel.Parcelize

@Parcelize
class ListProdutoPedido(var peodutosPedido: List<ProdutoPedido>): Parcelable {
}