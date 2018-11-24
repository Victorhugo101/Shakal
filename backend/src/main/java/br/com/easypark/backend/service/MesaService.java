package br.com.easypark.backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.model.entity.Mesa;

@Service
public class MesaService {
	
	@Autowired
	private MesaDAO mesaDAO;
	
	
	public boolean autenticar(String qrCode) {
		for(Mesa m: mesaDAO.findAll()) {
			if(m.getQrCode().equals(qrCode))
				return true;
		}
		return false;
		/*
		Mesa mesa = mesaDAO.findByQrCode(qrCode);
		return (mesa != null) ? true : false;
		*/	
	}
	

}