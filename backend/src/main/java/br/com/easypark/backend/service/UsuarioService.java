package br.com.easypark.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.model.dto.ClienteCadastroDTO;
import br.com.easypark.backend.model.dto.LoginDTO;
import br.com.easypark.backend.model.entity.Cliente;

@Service
public class UsuarioService {
	
	@Autowired
	private ClienteDAO clienteDao;
	
	
	public Boolean cadastrarCliente(ClienteCadastroDTO cliente) {
		
		Cliente c = new Cliente(cliente.getNome(),cliente.getEmail(),cliente.getSenha());
		clienteDao.save(c);
		return true;
		
	}
	
	
	public ClienteCadastroDTO logar(LoginDTO login) {
		for(Cliente c: clienteDao.findAll()) {
			if(c.getEmail().contains(login.getEmail())){
				if(c.getSenha().equals(login.getSenha()))
					return new ClienteCadastroDTO(c.getId(),c.getNomeCompleto(),c.getEmail());
			}
		}
		return new ClienteCadastroDTO(-1L,"","");
	}

}
