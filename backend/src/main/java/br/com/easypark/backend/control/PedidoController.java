package br.com.easypark.backend.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.easypark.backend.model.dto.PedidoEntradaDTO;
import br.com.easypark.backend.service.PedidoService;

@CrossOrigin
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	
	@Autowired
	private PedidoService pedidoService;
	
	
	 
	 @PostMapping("/save")
	 public ResponseEntity<PedidoEntradaDTO> save(@RequestBody PedidoEntradaDTO pedidoEntradaDTO) {
		return new ResponseEntity<PedidoEntradaDTO>(pedidoService.save(pedidoEntradaDTO),HttpStatus.OK);
		 
	 }


}