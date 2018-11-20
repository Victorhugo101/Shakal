package br.com.easypark.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.CategoriaDAO;
import br.com.easypark.backend.model.entity.Categoria;


@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	
	public List<Categoria> listAllCategories() {
		return this.categoriaDAO.findAll();

	}
}
