package br.com.easypark.backend.control;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easypark.backend.model.dto.ClienteCadastroDTO;
import br.com.easypark.backend.model.dto.LoginDTO;
import br.com.easypark.backend.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Boolean> cadastrar(@RequestBody ClienteCadastroDTO cliente) {
		return new ResponseEntity<Boolean>(usuarioService.cadastrarCliente(cliente), HttpStatus.OK);
	}
	
	/*
	@PostMapping("/logar")
	public ResponseEntity<ClienteCadastroDTO> logar(@RequestBody LoginDTO login) {
		return new ResponseEntity<ClienteCadastroDTO>(usuarioService.logar(login), HttpStatus.OK);
	}
	*/

}
