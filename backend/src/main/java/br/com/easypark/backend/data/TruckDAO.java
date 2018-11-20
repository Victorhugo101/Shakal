package br.com.easypark.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easypark.backend.model.entity.Truck;

public interface TruckDAO extends JpaRepository<Truck,Long> {

}
