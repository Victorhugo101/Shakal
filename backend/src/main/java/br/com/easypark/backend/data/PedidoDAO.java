package br.com.easypark.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easypark.backend.model.entity.Pedido;

public interface PedidoDAO extends JpaRepository<Pedido,Long>{

}
