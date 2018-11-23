package com.example.easypark.easyparkfinal.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.ProdutoListSerializable;
import com.example.easypark.easyparkfinal.beans.Truck;


public class ComprarProdutoFragment extends Fragment {

    private Produto produto;
    private Truck truck;
    private TextView txtvNomeTruck;
    private TextView txtvNomeProduto;
    private TextView txtvPreco;
    private Button btnMenos;
    private Button btnMais;
    private Button btnAdcionarAoCarrinho;
    private TextView txtvQuantidade;
    private int quantidade = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_comprar_produto, container, false);
        txtvNomeTruck = (TextView) view.findViewById(R.id.nomeFoodTruckDetalhesProduto);
        txtvNomeProduto = (TextView) view.findViewById(R.id.nomeProdutoDetalhes);
        txtvPreco = (TextView) view.findViewById(R.id.precoProdutoDetalhes);
        btnMenos = (Button) view.findViewById(R.id.btnMenosProduto);
        btnMais = (Button) view.findViewById(R.id.btnMaisProduto);
        txtvQuantidade = (TextView) view.findViewById(R.id.qtdProduto);
        btnAdcionarAoCarrinho = (Button) view.findViewById(R.id.btnAdcionarAoCarrinho);


        Bundle bundle = getArguments();
        produto = ((Produto) bundle.getSerializable("produto"));
        txtvNomeProduto.setText(produto.getNome());
        txtvPreco.setText("R$ " + String.valueOf(produto.getValor()));
        btnAdcionarAoCarrinho.setText("Adcionar ao carrinho R$ " + String.valueOf(produto.getValor() * quantidade));

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantidade > 1){
                    quantidade--;
                    txtvQuantidade.setText(String.valueOf(quantidade));
                    btnAdcionarAoCarrinho.setText("Adcionar ao carrinho R$ " + String.valueOf(produto.getValor() * quantidade));
                }
            }
        });
        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    quantidade++;
                    txtvQuantidade.setText(String.valueOf(quantidade));
                btnAdcionarAoCarrinho.setText("Adcionar ao carrinho R$ " + String.valueOf(produto.getValor() * quantidade));
            }
        });


        return view;
    }


}
