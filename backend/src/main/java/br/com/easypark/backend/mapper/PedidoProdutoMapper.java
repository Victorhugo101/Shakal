package br.com.easypark.backend.mapper;

import java.util.stream.Collectors;

import br.com.easypark.backend.model.dto.PedidoDetalheDTO;
import br.com.easypark.backend.model.dto.PedidoProdutoDTO;
import br.com.easypark.backend.model.entity.Pedido;
import br.com.easypark.backend.model.entity.PedidoProduto;

public abstract class PedidoProdutoMapper {
	
	public static PedidoProdutoDTO entityToDetail(PedidoProduto entity) {
		return new PedidoProdutoDTO(
				entity.getId(),
				entity.getProduto().getNome(),
				entity.getProduto().getValor(),
				entity.getQuantidade());
	}
	public static PedidoDetalheDTO entityToDetail(Pedido pedido) {
		return new PedidoDetalheDTO(
				pedido.getId(),
				pedido.getCliente().getUsername(),
				pedido.getMesa().getId().intValue(),
				pedido.getStatus().toString(),
				pedido.getProdutos().stream().map( produto -> PedidoProdutoMapper.entityToDetail(produto))
				.collect(Collectors.toList())
				);
	}

}
