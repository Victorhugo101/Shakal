package br.com.easypark.backend.mapper;

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

}
