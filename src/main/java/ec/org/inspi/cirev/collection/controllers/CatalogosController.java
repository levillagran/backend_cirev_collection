package ec.org.inspi.cirev.collection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.org.inspi.cirev.collection.models.Analisis;
import ec.org.inspi.cirev.collection.models.Cabinet;
import ec.org.inspi.cirev.collection.models.Clase;
import ec.org.inspi.cirev.collection.models.Colector;
import ec.org.inspi.cirev.collection.models.Especie;
import ec.org.inspi.cirev.collection.models.Familia;
import ec.org.inspi.cirev.collection.models.Filo;
import ec.org.inspi.cirev.collection.models.Genero;
import ec.org.inspi.cirev.collection.models.Habitat;
import ec.org.inspi.cirev.collection.models.IdentificadorDigitador;
import ec.org.inspi.cirev.collection.models.MetodoColectaAdulto;
import ec.org.inspi.cirev.collection.models.MetodoColectaInmaduro;
import ec.org.inspi.cirev.collection.models.MetodoIdentificacion;
import ec.org.inspi.cirev.collection.models.Orden;
import ec.org.inspi.cirev.collection.models.ProyectoArea;
import ec.org.inspi.cirev.collection.models.Sexo;
import ec.org.inspi.cirev.collection.models.Subfamilia;
import ec.org.inspi.cirev.collection.models.Subgenero;
import ec.org.inspi.cirev.collection.models.Taxonomia;
import ec.org.inspi.cirev.collection.models.User;
import ec.org.inspi.cirev.collection.models.VoucherMolecular;
import ec.org.inspi.cirev.collection.services.CatalogoService;
import ec.org.inspi.cirev.collection.models.Canton;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.collection.models.Provincia;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/catalogos")
public class CatalogosController {
	
	@Autowired
	CatalogoService catalogoService;
		
	@GetMapping(value = "/proyectos")
	public List<ProyectoArea> listProjectsAll() {
		return catalogoService.findProjectsAll();
	}
	
	@GetMapping(value = "/usuarios/{isInternal}")
	public List<User> listSigningUsersAll(@PathVariable boolean isInternal) {
		return catalogoService.findSigningUsersAll(isInternal);
	}
	
	@GetMapping(value = "/analisis")
	public List<Analisis> listAnalisisAll() {
		return catalogoService.findAnalisisAll();
	}
	
	@GetMapping(value = "/metodoColectaAdulto")
	public List<MetodoColectaAdulto> listMetodoColectaAdulto() {
		return catalogoService.listMetodoColectaAdulto();
	}
	
	@GetMapping(value = "/metodoColectaInmaduro")
	public List<MetodoColectaInmaduro> listMetodoColectaInmaduro() {
		return catalogoService.listMetodoColectaInmaduro();
	}
	
	@GetMapping(value = "/taxon")
	public List<Taxonomia> listTaxones() {
		return catalogoService.listTaxones();
	}
		
	@GetMapping(value = "/filos")
	public List<Filo> listFilos() {
		return catalogoService.listFilos();
	}

	@GetMapping(value = "/clases/{id}")
	public List<Clase> listClases(@PathVariable Integer id) {
		return catalogoService.listClases(id);
	}
	
	@GetMapping(value = "/ordenes/{id}")
	public List<Orden> listOrden(@PathVariable Integer id) {
		return catalogoService.listOrden(id);
	}
	
	@GetMapping(value = "/familias/{id}")
	public List<Familia> listFamilia(@PathVariable Integer id) {
		return catalogoService.listFamilia(id);
	}
	
	@GetMapping(value = "/subfamilias/{id}")
	public List<Subfamilia> listSubfamilia(@PathVariable Integer id) {
		return catalogoService.listSubfamilia(id);
	}
	
	@GetMapping(value = "/generos/{id}")
	public List<Genero> listGeneros(@PathVariable Integer id) {
		return catalogoService.listGeneros(id);
	}
	
	@GetMapping(value = "/subgeneros/{id}")
	public List<Subgenero> listSubgeneros(@PathVariable Integer id) {
		return catalogoService.listSubgeneros(id);
	}
	
	@GetMapping(value = "/especies/{id}")
	public List<Especie> listEspecies(@PathVariable Integer id) {
		return catalogoService.listEspecies(id);
	}
	
	@GetMapping(value = "/sexos")
	public List<Sexo> listSexos() {
		return catalogoService.listSexos();
	}
	
	@GetMapping(value = "/metodos")
	public List<MetodoIdentificacion> listMetodos() {
		return catalogoService.listMetodos();
	}
	
	@GetMapping(value = "/vouchers")
	public List<VoucherMolecular> listVouchers() {
		return catalogoService.listVouchers();
	}
	
	@GetMapping(value = "/habitats")
	public List<Habitat> listHabitats() {
		return catalogoService.listHabitats();
	}
	
	@GetMapping(value = "/colectores/{id}")
	public List<Colector> listColectores(@PathVariable Integer id) {
		return catalogoService.listColectores(id);
	}
	
	@GetMapping(value = "/provincias")
	public List<Provincia> procvinces() {
		return catalogoService.findProvinceAll();
	}
	
	@GetMapping(value = "/cantones/{provinciaId}")
	public List<Canton> cantons(@PathVariable Integer provinciaId) {
		return catalogoService.findCantonAll(provinciaId);
	}
	
	@GetMapping(value = "/parroquias/{cantonId}")
	public List<Parroquia> parishes(@PathVariable Integer cantonId) {
		return catalogoService.findParishAll(cantonId);
	}
	
	@GetMapping(value = "/identificadores")
	public List<IdentificadorDigitador> identificador() {
		return catalogoService.findIdentificador();
	}
	
	@GetMapping(value = "/digitadores")
	public List<IdentificadorDigitador> parishes() {
		return catalogoService.findDigitador();
	}
	
	@GetMapping(value = "/armarios")
	public List<Cabinet> listCabinet() {
		return catalogoService.listCabinet();
	}
	
		
}
