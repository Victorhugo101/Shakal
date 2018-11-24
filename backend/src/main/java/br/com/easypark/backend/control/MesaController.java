package br.com.easypark.backend.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.easypark.backend.service.MesaService;

@CrossOrigin
@RestController
@RequestMapping("/mesa")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@GetMapping("/autenticar/{qrCode}")
	 public ResponseEntity<Boolean> autenticar(@PathVariable String qrCode) {
		return new ResponseEntity<Boolean>(mesaService.autenticar(qrCode), HttpStatus.OK);
	}
}