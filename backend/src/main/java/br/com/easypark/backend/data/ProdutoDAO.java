package br.com.easypark.backend.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.easypark.backend.model.entity.Produto;

public interface ProdutoDAO extends JpaRepository<Produto,Long>{
	
	/*
	@Query("SELECT c FROM Produto p where p.categoria.id == ?1")
	List<Produto> findByCategory(long categoriaID);
	*/
	/*
	@Query("SELECT c FROM Produto p where p.truck.id == ?1")
	List<Produto> findByTruckId(long truckId);
	*/
	
}
