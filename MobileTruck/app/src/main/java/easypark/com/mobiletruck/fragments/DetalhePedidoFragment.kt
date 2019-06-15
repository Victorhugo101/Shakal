package easypark.com.mobiletruck.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.R.id.rv_lista_produtos_pedido
import easypark.com.mobiletruck.activities.TruckMainApp
import easypark.com.mobiletruck.adapter.ProdutoAdapter
import easypark.com.mobiletruck.model.Produto
import easypark.com.mobiletruck.model.ProdutoOverviewDTO
import easypark.com.mobiletruck.model.ProdutoPedido
import easypark.com.mobiletruck.network.PedidoService
import easypark.com.mobiletruck.parcelables.PedidoDetalheParcelable
import easypark.com.mobiletruck.utils.MessageBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetalhePedidoFragment : Fragment() {

    private var mAdapter: ProdutoAdapter? = null
    private lateinit var pedido: PedidoDetalheParcelable;
    private var produtos = mutableListOf<ProdutoPedido>()
    private lateinit var listView: RecyclerView
    private lateinit var txtNumeroPedido: TextView
    private lateinit var txtNumeroMesa: TextView
    private lateinit var btnFinalizar: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_detalhe_pedido, container, false)
        listView = view.findViewById( R.id.rv_lista_produtos_pedido)
        txtNumeroPedido = view.findViewById( R.id.textNumeroPedido)
        txtNumeroMesa = view.findViewById( R.id.textNumeroMesa)
        btnFinalizar = view.findViewById<Button>(R.id.btnFinalizarPedido)
        btnFinalizar.setOnClickListener{finalziarPedido(pedido.id.toLong())}
        this.carregarProdutos( )
        return view
    }

    private fun carregarProdutos(){


        pedido = arguments!!.getParcelable<PedidoDetalheParcelable>("pedido")
        txtNumeroPedido.text = "Pedido número "  + pedido.id.toString()
        txtNumeroMesa.text = "Mesa " + pedido.mesa.toString()
        produtos = arguments!!.getParcelable<PedidoDetalheParcelable>("pedido").produtos.peodutosPedido.toMutableList()
        mAdapter = ProdutoAdapter(produtos, requireContext())
        val mLayoutManager = LinearLayoutManager(requireContext())

        listView.layoutManager = mLayoutManager
        listView.itemAnimator = DefaultItemAnimator()
        listView.adapter = mAdapter

    }

    private fun finalziarPedido(id: Long){

        val call = PedidoService.newInstance().finalizarPedido(id)
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>?,
                                    response: Response<Boolean>?) {
                val fragmentTransaction = (context as AppCompatActivity)!!.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.main_container, ListPedidosFragment.instance)
                fragmentTransaction.addToBackStack("DetalhesPedido")
                fragmentTransaction.commit()

            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                MessageBuilder.exibirMensagem(t.message.orEmpty(),this@DetalhePedidoFragment.requireContext())
            }

        })

    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, TruckMainApp::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        fun newInstance() = DetalhePedidoFragment()
    }


}
