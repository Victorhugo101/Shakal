package br.com.easypark.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easypark.backend.model.entity.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria,Long>{

}
