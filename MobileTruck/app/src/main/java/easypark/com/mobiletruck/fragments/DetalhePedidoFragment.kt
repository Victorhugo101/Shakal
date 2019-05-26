package easypark.com.mobiletruck.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.activities.TruckMainApp
import easypark.com.mobiletruck.adapter.ProdutoAdapter
import easypark.com.mobiletruck.model.ProdutoOverviewDTO


class DetalhePedidoFragment : Fragment() {

    private var mAdapter: ProdutoAdapter? = null
    private val produtos = mutableListOf<ProdutoOverviewDTO>()
    private lateinit var listView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_pedidos, container, false)
        this.listView = view.findViewById<RecyclerView>(R.id.rv_lista_produtos)
        this.carregarProdutos()
        return view
    }

    private fun carregarProdutos(){

        produtos.add(0, ProdutoOverviewDTO(1,"Hamburger de siri",3))
        produtos.add(1, ProdutoOverviewDTO(1,"Hamburger de merda",3))
        produtos.add(2, ProdutoOverviewDTO(1,"Hamburger de Big Bosta",3))
        mAdapter = ProdutoAdapter(produtos, requireContext())
        val mLayoutManager = LinearLayoutManager(requireContext())
        listView.layoutManager = mLayoutManager
        listView.itemAnimator = DefaultItemAnimator()
        listView.adapter = mAdapter
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, TruckMainApp::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        fun newInstance() = DetalhePedidoFragment()
    }


}
