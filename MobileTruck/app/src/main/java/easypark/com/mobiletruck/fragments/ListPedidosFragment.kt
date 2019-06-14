package easypark.com.mobiletruck.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*

import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.activities.TruckMainApp
import easypark.com.mobiletruck.adapter.PedidoAdapter
import easypark.com.mobiletruck.adapter.ProdutoAdapter
import easypark.com.mobiletruck.adapter.RecycleViewClickListener
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import easypark.com.mobiletruck.model.PedidoStatusEnum
import easypark.com.mobiletruck.parcelables.ListPedidosOverviewDTO

//import kotlinx.android.synthetic.main.fragment_list_pedidos.*


class ListPedidosFragment : Fragment(), RecycleViewClickListener
{



    private var mAdapter: PedidoAdapter? = null
    private var pedidos = mutableListOf<PedidoOverviewDTO>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_pedidos, container, false)
        this.recyclerView = view.findViewById<RecyclerView>(R.id.rv_lista_pedidos)
        this.carregarPedidos()

        return view
    }

    override fun onClickListener(view: View?, position: Int) {
        val adapter = recyclerView.getAdapter() as PedidoAdapter
        adapter.chamaProximoFragmento(position, this)
    }

    private fun carregarPedidos(){
        /*
        pedidos.add(0,PedidoOverviewDTO(1,"Josenilsom",3,PedidoStatusEnum.PRONTO))
        pedidos.add(1,PedidoOverviewDTO(2,"Robervalsom",3,PedidoStatusEnum.PREPARANDO))
        pedidos.add(2,PedidoOverviewDTO(3,"Mariucleuçio",3,PedidoStatusEnum.PREPARANDO))
        */
        this.pedidos =  arguments!!.getParcelable<ListPedidosOverviewDTO>("pedidos").pedidosOverviewDTO.toMutableList()
        mAdapter = PedidoAdapter(pedidos, requireContext())
        mAdapter!!.setPedidoRecycleViewOnClick(this)
        val mLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }



    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, TruckMainApp::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        fun newInstance() = ListPedidosFragment()
    }





}
