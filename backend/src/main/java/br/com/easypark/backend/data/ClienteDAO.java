package br.com.easypark.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easypark.backend.model.entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente,Long> {

}
