package easypark.com.mobiletruck.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Parcelize
class PedidoOverviewDTO(val id: Int, val nomeCliente: String, val mesa: Int, val status: PedidoStatusEnum): Serializable, Parcelable