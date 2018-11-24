package br.com.easypark.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.data.PedidoDAO;
import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.model.dto.PedidoEntradaDTO;
import br.com.easypark.backend.model.entity.Cliente;
import br.com.easypark.backend.model.entity.Mesa;
import br.com.easypark.backend.model.entity.Pedido;
import br.com.easypark.backend.model.entity.Produto;

@Service
public class PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private MesaDAO mesaDAO;
	
	public boolean save(PedidoEntradaDTO pedidoEntradaDTO) {
		
		Pedido p;
		Cliente cliente = clienteDAO.findById(pedidoEntradaDTO.getCliente()).get();
		Mesa m = mesaDAO.findById(pedidoEntradaDTO.getMesa()).get();
		List<Produto> produtos = new ArrayList<>();
		
		for(short i = 0; i < pedidoEntradaDTO.getProdutos().size(); i++) {
			System.out.println(pedidoEntradaDTO.getProdutos());
			produtos.add(produtoDAO.getOne(pedidoEntradaDTO.getProdutos().get(i)));
		}
		
		p = new Pedido(0,cliente, produtos,m);
		p.setStatus(1);
		pedidoDAO.save(p);
		return true;
	}
}
