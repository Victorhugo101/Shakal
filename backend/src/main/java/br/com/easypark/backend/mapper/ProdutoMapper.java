package br.com.easypark.backend.mapper;


import br.com.easypark.backend.model.dto.ProdutoDTO;

import br.com.easypark.backend.model.entity.Produto;



public abstract class ProdutoMapper {
	
	public static ProdutoDTO entityToDetail(Produto produto) {
		return new ProdutoDTO(
				produto.getId(),
				produto.getNome(),
				String.valueOf(produto.getValor())
				);
	}

}
