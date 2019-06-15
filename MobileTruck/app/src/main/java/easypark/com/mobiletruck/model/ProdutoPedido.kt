package easypark.com.mobiletruck.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class ProdutoPedido(val id: Int, val nome: String, val valor: Double, val quantidade: Int):Parcelable, Serializable {
}