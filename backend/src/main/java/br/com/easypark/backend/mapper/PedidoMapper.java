package br.com.easypark.backend.mapper;

import br.com.easypark.backend.model.dto.PedidoDetalheDTO;
import br.com.easypark.backend.model.entity.Pedido;

import java.util.stream.Collectors;

public abstract class PedidoMapper {
	
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
