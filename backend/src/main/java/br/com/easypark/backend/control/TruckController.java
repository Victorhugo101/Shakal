package br.com.easypark.backend.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easypark.backend.model.dto.TruckDTO;
import br.com.easypark.backend.service.TruckService;

@CrossOrigin
@RestController
@RequestMapping("/truck")
public class TruckController {

	
	@Autowired
	private TruckService truckService;
	
	@GetMapping("/listar/mesa/{id}")
	 public ResponseEntity<List<TruckDTO>> listarPorMesa(@PathVariable long id) {

		return new ResponseEntity<List<TruckDTO>>(truckService.listarTrucksPertodaMesa(id),HttpStatus.OK);
		 
	 }
}
