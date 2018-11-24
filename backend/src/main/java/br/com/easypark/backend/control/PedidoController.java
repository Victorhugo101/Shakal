package br.com.easypark.backend.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.easypark.backend.model.dto.PedidoEntradaDTO;
import br.com.easypark.backend.model.dto.PedidoSaidaDTO;
import br.com.easypark.backend.service.PedidoService;

@CrossOrigin
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	
	@Autowired
	private PedidoService pedidoService;
	
	
	 
	 @PostMapping("/save")
	 public ResponseEntity<Boolean> save(@RequestBody PedidoEntradaDTO pedidoEntradaDTO) {
		 if(pedidoService.save(pedidoEntradaDTO)) {
			 return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		 }
		return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/listar/{id}")
	 public ResponseEntity<List<PedidoSaidaDTO>> listMy(@PathVariable long id) {
		return new ResponseEntity<List<PedidoSaidaDTO>>(this.pedidoService.listarMeusPedidos(id),HttpStatus.OK);
		 
	 }


}
