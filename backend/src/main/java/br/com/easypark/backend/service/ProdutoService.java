package br.com.easypark.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.model.dto.ProdutoDTO;
import br.com.easypark.backend.model.entity.Produto;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	
	public List<ProdutoDTO> listarProdutosPorCategoria(long categoriaID) {
		List<Produto> pesquisa = new ArrayList<>();
		for(Produto r: produtoDAO.findAll()) {
			if(r.getCategoira().getId() == categoriaID)
			pesquisa.add(r);
		}
		List<ProdutoDTO> resultado = new ArrayList<>();
		for(Produto p: pesquisa) {
			resultado.add(new ProdutoDTO(p.getId(),p.getNome(),p.getValor()));
		}
		return resultado;
	}
	public List<ProdutoDTO> listarProdutosPorTruck(long categoriaID) {
		List<ProdutoDTO> pesquisa = new ArrayList<>();
		for(Produto r: produtoDAO.findAll()) {
			if(r.getTruck().getId() == categoriaID)
			pesquisa.add(new ProdutoDTO(r.getId(),r.getNome(),r.getValor()));
		}
		return pesquisa;
	}
}
