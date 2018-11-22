package br.com.easypark.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.data.TruckDAO;
import br.com.easypark.backend.model.dto.TruckDTO;
import br.com.easypark.backend.model.entity.Mesa;
import br.com.easypark.backend.model.entity.Truck;

@Service
public class TruckService {
	
	
	@Autowired
	private TruckDAO truckDAO;
	
	@Autowired
	private MesaDAO mesaDAO;
	
	public List<TruckDTO> listarTrucksPertodaMesa(long mesaId) {
		Mesa mesa = mesaDAO.findById(mesaId).get();
		List<TruckDTO> result = new ArrayList<>();
		for(Truck tr : truckDAO.findAll()) {
			if(this.distanciaGeografica(tr.getLatitude(), tr.getLongitude(), mesa.getLatitude(), mesa.getLongitude())
					< 10) {
				result.add(new TruckDTO(tr.getId(),tr.getNomeFantasia(), tr.getCnpj()));
			}
		}
		return result;
	}
	
	public double distanciaGeografica(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371.01; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));
    }
}
