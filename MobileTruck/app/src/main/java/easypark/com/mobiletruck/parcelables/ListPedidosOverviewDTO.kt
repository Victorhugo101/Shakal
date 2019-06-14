package easypark.com.mobiletruck.parcelables

import android.os.Parcel
import android.os.Parcelable
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import kotlinx.android.parcel.Parcelize

@Parcelize
class ListPedidosOverviewDTO(var pedidosOverviewDTO: List<PedidoOverviewDTO> ): Parcelable