package easypark.com.mobiletruck.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.model.ProdutoOverviewDTO

class ProdutoAdapter (private val produtos: MutableList<ProdutoOverviewDTO>, private val context: Context)
    : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_produto_list_row, p0, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        val produto = produtos[p1]

        //viewHolder.codigo.text = pedido.id.toString()
        viewHolder.nome.text = produto.nome
        viewHolder.quantidade.text = produto.quantidade.toString()
        //viewHolder.preco.text = pedido. .toString()


        /*
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, FormularyActivity::class.java)
            intent.putExtra("codigo", pedidos[p1].id)
            it.context.startActivity(intent)
        }
        */
    }
    override fun getItemCount(): Int {
        return produtos.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        //internal var preco: TextView
        internal var nome: TextView
        internal var quantidade: TextView
        //internal var imagem: ImageView

        init {
            //preco = view.findViewById(R.id.precoProduto)
            nome = view.findViewById(R.id.nomeProduto)
            quantidade= view.findViewById(R.id.quantidadeProduto)
            //imagem = view.findViewById(R.id)
        }
    }
}