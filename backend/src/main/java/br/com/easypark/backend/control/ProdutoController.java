package br.com.easypark.backend.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.easypark.backend.model.dto.ProdutoDTO;
import br.com.easypark.backend.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping("/categoria/{id}")
	 public ResponseEntity<List<ProdutoDTO>> listarPorCategoria(@PathVariable long id) {
		return new ResponseEntity<List<ProdutoDTO>>(produtoService.listarProdutosPorCategoria(id),HttpStatus.OK);
		 
	}
	@GetMapping("/truck/{id}")
	public ResponseEntity<List<ProdutoDTO>> listarPorTruck(@PathVariable long id) {
		return new ResponseEntity<List<ProdutoDTO>>(produtoService.listarProdutosPorTruck(id),HttpStatus.OK);
		 
	}

}
