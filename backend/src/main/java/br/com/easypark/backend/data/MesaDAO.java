package br.com.easypark.backend.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.easypark.backend.model.entity.Mesa;

public interface MesaDAO extends JpaRepository<Mesa,Long>{

	/*
	@Query("SELECT c FROM Mesa m where m.qrCode == :qrCode")
	Mesa findByQrCode(@Param("qrCode") String qrCode);
	*/
}