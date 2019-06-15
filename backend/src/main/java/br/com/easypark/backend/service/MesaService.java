package br.com.easypark.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.easypark.backend.exception.*;
import br.com.easypark.backend.contracts.service.IMesaService;
import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.model.entity.Mesa;

@Service
public class MesaService implements IMesaService{
	
	@Autowired
	private MesaDAO mesaDAO;
	
	
	@Override
	public Long autenticar(String qrCode) {
		Mesa result = this.mesaDAO.findByQrcode(qrCode)
				.orElseThrow(()-> new ResourceNotFoundException("QrCode inválido")); 
		return result.getId();
	}
	

}
