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

import ec.org.inspi.cirev.collection.services.CuracionesService;
import ec.org.inspi.cirev.collection.models.IdentificadorDigitador;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleAlmacenado;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleMontar;
import ec.org.inspi.cirev.collection.payload.request.CuracionRequest;
import ec.org.inspi.cirev.collection.payload.response.AlmacenadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.CuracionResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.MontadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/curaciones")
public class CuracionesController {
	@Autowired
	private CuracionesService curSrv;
		
	@GetMapping(value = "/all")
	public List<RequerimientoResponseLista> listAll() {
		return curSrv.findAll();
	}
	
	@PostMapping(value = "/save")
	public List<RequerimientoResponseLista> save(@RequestBody CuracionRequest requerimiento) {
		return curSrv.save(requerimiento);
	}
	
	@PostMapping(value = "/saveStored")
	public CuracionResponseEditar saveStored(@RequestBody List<RequerimientoDetalleAlmacenado> registro) {
		return curSrv.saveStored(registro);
	}
	
	@PostMapping(value = "/saveMount")
	public CuracionResponseEditar saveMount(@RequestBody List<RequerimientoDetalleMontar> registro) {
		return curSrv.saveMount(registro);
	}
	
	@GetMapping(value = "/findById/{requerimientoId}")
	public CuracionResponseEditar findById(@PathVariable Integer requerimientoId) {
		return curSrv.findById(requerimientoId);
	}
	
	@GetMapping(value = "/storedById/{id}")
	public List<AlmacenadosResponseEditar> storedById(@PathVariable Integer id) {
		return curSrv.storedById(id);
	}
	
	@GetMapping(value = "/mountedById/{id}")
	public List<MontadosResponseEditar> mountedById(@PathVariable Integer id) {
		return curSrv.mountedById(id);
	}
	
	@GetMapping(value = "/comprobanteCreate/{requerimientoId}")
	public String createVoucher(@PathVariable Integer requerimientoId) {
		return curSrv.createVoucher(requerimientoId);
	}
	
	@PostMapping(value = "/saveIdentificador")
	public List<IdentificadorDigitador> saveIdentificador(@RequestBody IdentificadorDigitador identificador) {
		return curSrv.saveIdentificador(identificador);
	}
		
	@PostMapping(value = "/saveDigitador")
	public List<IdentificadorDigitador> saveDigitador(@RequestBody IdentificadorDigitador digitador) {
		return curSrv.saveDigitador(digitador);
	}
	
	@GetMapping(value = "/isEnd/{id}")
	public String isEnd(@PathVariable Integer id) {
		return curSrv.isEnd(id);
	}
}
