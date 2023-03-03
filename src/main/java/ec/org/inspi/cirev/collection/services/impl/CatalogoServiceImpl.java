package ec.org.inspi.cirev.collection.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import ec.org.inspi.cirev.collection.repositories.AnalisisRepository;
import ec.org.inspi.cirev.collection.repositories.CabinetRepository;
import ec.org.inspi.cirev.collection.repositories.ClaseRepository;
import ec.org.inspi.cirev.collection.repositories.ColectorRepository;
import ec.org.inspi.cirev.collection.repositories.EspecieRepository;
import ec.org.inspi.cirev.collection.repositories.FamiliaRepository;
import ec.org.inspi.cirev.collection.repositories.FiloRepository;
import ec.org.inspi.cirev.collection.repositories.GeneroRepository;
import ec.org.inspi.cirev.collection.repositories.HabitatRepository;
import ec.org.inspi.cirev.collection.repositories.IdentificadorDigitadorRepository;
import ec.org.inspi.cirev.collection.repositories.MetodoColectaAdultoRepository;
import ec.org.inspi.cirev.collection.repositories.MetodoColectaInmaduroRepository;
import ec.org.inspi.cirev.collection.repositories.MetodoIdentificacionRepository;
import ec.org.inspi.cirev.collection.repositories.OrdenRepository;
import ec.org.inspi.cirev.collection.repositories.ProyectoAreaRepository;
import ec.org.inspi.cirev.collection.repositories.SexoRepository;
import ec.org.inspi.cirev.collection.repositories.SubfamiliaRepository;
import ec.org.inspi.cirev.collection.repositories.SubgeneroRepository;
import ec.org.inspi.cirev.collection.repositories.TaxonomiaRepository;
import ec.org.inspi.cirev.collection.repositories.UserRepository;
import ec.org.inspi.cirev.collection.repositories.VoucherMolecularRepository;
import ec.org.inspi.cirev.collection.services.CatalogoService;
import ec.org.inspi.cirev.collection.repositories.CantonParroquiaRepository;
import ec.org.inspi.cirev.collection.repositories.CantonRepository;
import ec.org.inspi.cirev.collection.repositories.ParroquiaRepository;
import ec.org.inspi.cirev.collection.repositories.ProvinciaCantonRepository;
import ec.org.inspi.cirev.collection.repositories.ProvinciaRepository;
import ec.org.inspi.cirev.collection.models.Canton;
import ec.org.inspi.cirev.collection.models.CantonParroquia;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.collection.models.Provincia;
import ec.org.inspi.cirev.collection.models.ProvinciaCanton;

@Service("catalogoService")
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	private ProyectoAreaRepository proyectoAreaRepository;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AnalisisRepository analisisRepository;
	@Autowired
	private MetodoColectaAdultoRepository metColAdultoRep;
	@Autowired
	private MetodoColectaInmaduroRepository metColInmaduroRep;
	@Autowired
	private TaxonomiaRepository taxoRepo;
	@Autowired
	private FiloRepository filoRepo;
	@Autowired
	private ClaseRepository claseRepo;
	@Autowired
	private OrdenRepository ordenRepo;
	@Autowired
	private FamiliaRepository famRepo;
	@Autowired
	private SubfamiliaRepository subfamRepo;
	@Autowired
	private GeneroRepository genRepo;
	@Autowired
	private SubgeneroRepository subgenRepo;
	@Autowired
	private EspecieRepository espeRepo;
	@Autowired
	private SexoRepository sexRepo;
	@Autowired
	private MetodoIdentificacionRepository metRepo;
	@Autowired
	private VoucherMolecularRepository couRepo;
	@Autowired
	private HabitatRepository haRepo;
	@Autowired
	private ColectorRepository colRepo;
	@Autowired
	private ProvinciaRepository proRepo;
	@Autowired
	private CantonRepository cantonRepo;
	@Autowired
	private ProvinciaCantonRepository proCanRepo;
	@Autowired
	private ParroquiaRepository parRepo;
	@Autowired
	private CantonParroquiaRepository canParrRepo;
	@Autowired
	private IdentificadorDigitadorRepository identRepo;
	@Autowired
	private CabinetRepository cabiRepo;

	@Override
	public List<ProyectoArea> findProjectsAll() {
		return (List<ProyectoArea>) proyectoAreaRepository.findAll();
	}

	@Override
	public List<User> findSigningUsersAll(boolean isInternal) {
		return userRepo.findAllByIsInternalAndActiveTrue(isInternal);
	}

	@Override
	public List<Analisis> findAnalisisAll() {
		return (List<Analisis>) analisisRepository.findAll();
	}

	@Override
	public List<MetodoColectaAdulto> listMetodoColectaAdulto() {
		return (List<MetodoColectaAdulto>) metColAdultoRep.findAll();
	}

	@Override
	public List<MetodoColectaInmaduro> listMetodoColectaInmaduro() {
		return (List<MetodoColectaInmaduro>) metColInmaduroRep.findAll();
	}

	@Override
	public List<Taxonomia> listTaxones() {
		return (List<Taxonomia>) taxoRepo.findAllByOrdenId(2);
	}
	
	@Override
	public List<Filo> listFilos() {
		return (List<Filo>) filoRepo.findAll();
	}
	
	@Override
	public List<Clase> listClases(Integer id) {
		return claseRepo.findAllByFiloId(id);
	}
	
	@Override
	public List<Orden> listOrden(Integer id) {
		return ordenRepo.findAllByClaseId(id);
	}
	
	@Override
	public List<Familia> listFamilia(Integer id) {
		return famRepo.findAllByOrdenId(id);
	}
	
	@Override
	public List<Subfamilia> listSubfamilia(Integer id) {
		return subfamRepo.findAllByFamiliaId(id);
	}
	
	@Override
	public List<Genero> listGeneros(Integer id) {
		return genRepo.findAllBySubfamiliaId(id);
	}
	
	@Override
	public List<Subgenero> listSubgeneros(Integer id) {
		return subgenRepo.findAllByGeneroId(id);
	}
	
	@Override
	public List<Especie> listEspecies(Integer id) {
		return espeRepo.findAllBySubgeneroId(id);
	}
	
	@Override
	public List<Sexo> listSexos() {
		return (List<Sexo>) sexRepo.findAll();
	}
	
	@Override
	public List<MetodoIdentificacion> listMetodos() {
		return (List<MetodoIdentificacion>) metRepo.findAll();
	}
	
	@Override
	public List<VoucherMolecular> listVouchers() {
		return (List<VoucherMolecular>) couRepo.findAll();
	}

	@Override
	public List<Habitat> listHabitats() {
		return (List<Habitat>) haRepo.findAll();
	}
	
	@Override
	public List<Colector> listColectores(Integer id) {
		return colRepo.findAllByProjectIdAndActiveTrue(id);
	}
	
	@Override
	public List<Provincia> findProvinceAll() {
		return (List<Provincia>) proRepo.findAll();
	}

	@Override
	public List<Canton> findCantonAll(Integer projectId) {
		List<ProvinciaCanton> proCans = proCanRepo.findAllByProvinceId(projectId);
		List<Canton> canton = new ArrayList<>();
		for (ProvinciaCanton proCan : proCans) {
			canton.add(cantonRepo.findById(proCan.getCantonId()).get());
		}
		return canton;
	}
	
	@Override
	public List<Parroquia> findParishAll(Integer cantontId) {
		List<CantonParroquia> proParrs = canParrRepo.findAllByCantonId(cantontId);
		List<Parroquia> parr = new ArrayList<>();
		for (CantonParroquia proParr : proParrs) {
			parr.add(parRepo.findById(proParr.getParishId()).get());
		}
		return parr;
	}

	@Override
	public List<IdentificadorDigitador> findIdentificador() {
		return identRepo.findAllByRolId(3);
	}

	@Override
	public List<IdentificadorDigitador> findDigitador() {
		return identRepo.findAllByRolId(2);
	}

	@Override
	public List<Cabinet> listCabinet() {
		return cabiRepo.findAllByActiveTrue();
	}
	
}
