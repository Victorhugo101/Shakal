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

import br.com.easypark.backend.model.entity.Categoria;
import br.com.easypark.backend.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	 public ResponseEntity<List<Categoria>> autenticar(@PathVariable String qrCode) {
		return new ResponseEntity<List<Categoria>>(categoriaService.listAllCategories(), HttpStatus.OK);
	}
}
