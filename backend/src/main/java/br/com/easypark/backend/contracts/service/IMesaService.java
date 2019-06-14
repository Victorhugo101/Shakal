package br.com.easypark.backend.contracts.service;

import br.com.easypark.backend.exception.ResourceNotFoundException;

public interface IMesaService {
	
	boolean autenticar(String qrCode) throws ResourceNotFoundException;

}
