package ec.org.inspi.cirev.collection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.org.inspi.cirev.collection.payload.request.EstadoRequest;
import ec.org.inspi.cirev.collection.payload.request.EstadoValidadorRequest;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.services.EstadoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/estados")
public class EstadosController {
	@Autowired
	private EstadoService estadoService;

	@PostMapping(value = "/changeStatus")
	public List<RequerimientoResponseLista> changeStatus(@RequestBody EstadoRequest requerimiento) {
		return estadoService.changeStatus(requerimiento);
	}
	
	@PostMapping(value = "/changeStatusValidator")
	public List<RequerimientoResponseLista> changeStatusVal(@RequestBody EstadoValidadorRequest requerimiento) {
		return estadoService.changeStatusValidator(requerimiento);
	}
}
