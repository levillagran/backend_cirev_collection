package ec.org.inspi.cirev.collection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.org.inspi.cirev.collection.models.Colector;
import ec.org.inspi.cirev.collection.models.ProyectoArea;
import ec.org.inspi.cirev.collection.models.User;
import ec.org.inspi.cirev.collection.payload.request.RequerimientoRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.services.RequerimientoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/requerimientos")
public class RequerimientosController {
	@Autowired
	private RequerimientoService requerimientoService;
		
	@GetMapping(value = "/all")
	public List<RequerimientoResponseLista> listAll() {
		return requerimientoService.findAll();
	}
	
	@PostMapping(value = "/save")
	public List<RequerimientoResponseLista> saveUsuario(@RequestBody RequerimientoRequest requerimiento) {
		return requerimientoService.save(requerimiento);
	}
	
	@GetMapping(value = "/findById/{requerimientoId}")
	public RequerimientoResponseEditar findById(@PathVariable Integer requerimientoId) {
		return requerimientoService.findById(requerimientoId);
	}

	@GetMapping(value = "/comprobanteView/{requerimientoId}")
	public String findVoucherById(@PathVariable Integer requerimientoId) {
		return requerimientoService.findVoucherById(requerimientoId);
	}
	
	@GetMapping(value = "/comprobanteCreate/{requerimientoId}")
	public String createVoucher(@PathVariable Integer requerimientoId) {
		return requerimientoService.createVoucher(requerimientoId);
	}
	
	@PostMapping(value = "/comprobanteSave")
	public List<RequerimientoResponseLista> saveComprobante(@RequestBody UploadRequest uploadRequest) {
		return requerimientoService.saveComprobante(uploadRequest);
	}
	
	@PostMapping(value = "/colectorSave")
	public List<Colector> saveColector(@RequestBody Colector colector) {
		return requerimientoService.saveColector(colector);
	}
	
	@PostMapping(value = "/requestSave")
	public List<User> requestSave(@RequestBody User solicitante) {
		return requerimientoService.requestSave(solicitante);
	}
	
	@PostMapping(value = "/projectSave")
	public List<ProyectoArea> projectSave(@RequestBody ProyectoArea proyecto) {
		return requerimientoService.projectSave(proyecto);
	}
	
}
