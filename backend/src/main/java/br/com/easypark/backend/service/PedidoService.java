package br.com.easypark.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.data.PedidoDAO;
import br.com.easypark.backend.data.PedidoProdutoDAO;
import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.data.TruckDAO;
import br.com.easypark.backend.exception.ResourceNotFoundException;
import br.com.easypark.backend.model.dto.PedidoEntradaDTO;
import br.com.easypark.backend.model.dto.PedidoSaidaDTO;
import br.com.easypark.backend.model.dto.ProdutoQuantidadeDTO;
import br.com.easypark.backend.model.entity.Cliente;
import br.com.easypark.backend.model.entity.Mesa;
import br.com.easypark.backend.model.entity.Pedido;
import br.com.easypark.backend.model.entity.PedidoProduto;
import br.com.easypark.backend.model.entity.Truck;
import br.com.easypark.backend.model.enums.StatusPedidoEnum;

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

	@Autowired
	private PedidoProdutoDAO pedidoProdutoDAO;

	@Autowired
	private TruckDAO truckDAO;

	public boolean save(PedidoEntradaDTO pedidoEntradaDTO) {
		
		Pedido p;
		Cliente cliente = clienteDAO.findById(pedidoEntradaDTO.getCliente())
				.orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado"));
		Truck truck = truckDAO.findById(pedidoEntradaDTO.getTruck())
				.orElseThrow(()-> new ResourceNotFoundException("Truck não encontrado"));
		Mesa m = mesaDAO.findById(pedidoEntradaDTO.getMesa()).get();
		p = new Pedido(cliente,m,truck);
		p.setStatus(StatusPedidoEnum.PREPARANDO);
		pedidoDAO.save(p);
		
		//List<PedidoProduto> produtos = new ArrayList<>();
		for(ProdutoQuantidadeDTO produto: pedidoEntradaDTO.getProdutos()) {
			pedidoProdutoDAO.save(new PedidoProduto(
					produtoDAO.getOne(produto.getProduto()) , p,produto.getQuantidade().intValue() ) );
		}
		return true;
	}

	public List<PedidoSaidaDTO> listarPedidosCliente(Long id) {
		List<PedidoSaidaDTO> pedidos = new ArrayList<PedidoSaidaDTO>();
		for (Pedido p : this.pedidoDAO.findAll()) {
			if (p.getCliente().getId() == id) {
				pedidos.add(new PedidoSaidaDTO(p.getId(),
						(p.getProdutos().size() > 0) ? p.getProdutos().get(0).getProduto().getTruck().getNomeFantasia()
								: "String teste",
						"Preparando"));
			}

		}
		return pedidos;

	}

	public List<PedidoSaidaDTO> listarPedidosTruck(Long id) {
		List<PedidoSaidaDTO> pedidos = new ArrayList<PedidoSaidaDTO>();
		for (Pedido p : this.pedidoDAO.findAll()) {
			if (p.getTruck().getId() == id) {
				pedidos.add(new PedidoSaidaDTO(p.getId(),
						(p.getProdutos().size() > 0) ? p.getProdutos().get(0).getProduto().getTruck().getNomeFantasia()
								: "String teste",
						"Preparando"));
			}

		}
		return pedidos;

	}

	public Boolean finalizarPedido(long pedidoId, long truckId) {
		Pedido pedido = this.pedidoDAO.findById(pedidoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido Não encontrado"));
		pedido.setStatus(StatusPedidoEnum.FINALIZADO);
		this.pedidoDAO.save(pedido);
		return true;
	}
}
