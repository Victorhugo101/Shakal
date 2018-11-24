package br.com.easypark.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easypark.backend.model.entity.PedidoProduto;

public interface PedidoProdutoDAO extends JpaRepository<PedidoProduto,Long> {

}
