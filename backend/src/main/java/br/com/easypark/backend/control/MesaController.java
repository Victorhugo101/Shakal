package br.com.easypark.backend.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.easypark.backend.model.dto.QrCodeDTO;
import br.com.easypark.backend.service.MesaService;

@CrossOrigin
@RestController
@RequestMapping("/mesa")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<Long> autenticar(@RequestBody QrCodeDTO qrCodeDTO) {
		return new ResponseEntity<Long>(mesaService.autenticar(qrCodeDTO.getQrcode()), HttpStatus.OK);
	}
}
