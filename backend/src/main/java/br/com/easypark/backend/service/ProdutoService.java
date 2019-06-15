package br.com.easypark.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.data.TruckDAO;
import br.com.easypark.backend.exception.ResourceNotFoundException;
import br.com.easypark.backend.mapper.ProdutoMapper;
import br.com.easypark.backend.model.dto.ProdutoDTO;
import br.com.easypark.backend.model.entity.Produto;
import br.com.easypark.backend.model.entity.Truck;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private TruckDAO truckDAO;
	
	
	public List<ProdutoDTO> listarProdutosPorCategoria(long categoriaID) {
		List<Produto> pesquisa = new ArrayList<>();
		for(Produto r: produtoDAO.findAll()) {
			if(r.getCategoira().getId() == categoriaID)
			pesquisa.add(r);
		}
		List<ProdutoDTO> resultado = new ArrayList<>();
		for(Produto p: pesquisa) {
			resultado.add(new ProdutoDTO(p.getId(),p.getNome(),String.valueOf(p.getValor())));
		}
		return resultado;
	}
	public List<ProdutoDTO> listarProdutosPorTruck(long truckId) {
		/*
		return this.produtoDAO.findByTruckId(truckId)
				.stream().map( produto -> ProdutoMapper.entityToDetail(produto))
				.collect(Collectors.toList());
				*/
				
		Truck search = this.truckDAO.findById(truckId)
				.orElseThrow(()-> new ResourceNotFoundException("Pedido" + truckId +"não encontrado"));
		
		return search.getProdutos().stream().map( produto -> ProdutoMapper.entityToDetail(produto))
		.collect(Collectors.toList());
		
		
		/*
		List<ProdutoDTO> pesquisa = new ArrayList<>();
		for(Produto r: produtoDAO.findAll()) {
			if(r.getTruck().getId() == truckId)
			pesquisa.add(new ProdutoDTO(r.getId(),r.getNome(),String.valueOf(r.getValor())));
		}
		return pesquisa;
		*/
		
		
	}
}
