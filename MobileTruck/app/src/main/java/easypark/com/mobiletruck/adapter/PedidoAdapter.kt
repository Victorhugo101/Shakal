package easypark.com.mobiletruck.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.fragments.DetalhePedidoFragment
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import android.support.v7.app.AppCompatActivity
import android.util.Log
import easypark.com.mobiletruck.model.PedidoDetalhe
import easypark.com.mobiletruck.network.PedidoService
import easypark.com.mobiletruck.parcelables.ListProdutoPedido
import easypark.com.mobiletruck.parcelables.PedidoDetalheParcelable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PedidoAdapter(private val pedidos: MutableList<PedidoOverviewDTO>, private val context: Context)
    : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    private var recycleViewClickListener: RecycleViewClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_pedido_list_row, p0, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        val pedido: PedidoOverviewDTO = pedidos.get(p1)

        viewHolder.codigo.text = pedido.id.toString()
        viewHolder.numeroMesa.text = pedido.mesa.toString()
        viewHolder.nomeCliente.text = pedido.nomeCliente
        viewHolder.status.text = pedido.status


        viewHolder.itemView.setOnClickListener { v ->
            chamaProximoFragmento(pedido.id)
        }



        //val manager = (context as AppCompatActivity).supportFragmentManager
    }

    fun chamaProximoFragmento(id: Int) {
        val call = PedidoService.newInstance().detalharPedidos(id.toLong())
        call.enqueue(object : Callback<PedidoDetalhe> {
            override fun onResponse(call: Call<PedidoDetalhe>?,
                                    response: Response<PedidoDetalhe>?) {


                var fragment = DetalhePedidoFragment.newInstance()


                val listaProdutoPedidoParcelabe = ListProdutoPedido(response!!.body()!!.produtos)
                val detalheParcelable = PedidoDetalheParcelable(
                        response!!.body()!!.id,
                        response!!.body()!!.nomeCliente,
                        response!!.body()!!.mesa,
                        response!!.body()!!.status,
                        listaProdutoPedidoParcelabe
                )



                val args = Bundle()
                args.putParcelable("pedido",detalheParcelable)
                fragment.arguments = args

                val fragmentTransaction = (context as AppCompatActivity)!!.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.main_container, fragment)
                fragmentTransaction.addToBackStack("ListaPedido")
                fragmentTransaction.commit()

            }

            override fun onFailure(call: Call<PedidoDetalhe>?,
                                   t: Throwable?) {
                Log.d("MEnsagem",t.toString())
            }


        })





    }
    override fun getItemCount(): Int {
        return pedidos.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {


        override fun onClick(p0: View?) {
            if (recycleViewClickListener != null) {
                recycleViewClickListener?.onClickListener(p0 , adapterPosition)
            }
        }



        internal var nomeCliente: TextView
        internal var numeroMesa: TextView
        internal var codigo: TextView
        internal var status: TextView

        init {
            codigo = view.findViewById(R.id.codigoPedido)
            nomeCliente = view.findViewById(R.id.nomeCliente)
            status= view.findViewById(R.id.statusPedido)
            numeroMesa = view.findViewById(R.id.numeroPedido)

        }


    }


    fun setPedidoRecycleViewOnClick(r: RecycleViewClickListener) {
        this.recycleViewClickListener = r
    }


}