package ec.org.inspi.cirev.collection.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import ec.org.inspi.cirev.collection.models.Cabinet;
import ec.org.inspi.cirev.collection.models.Clase;
import ec.org.inspi.cirev.collection.models.DocumentosEvidencia;
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
import ec.org.inspi.cirev.collection.models.Requerimiento;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalle;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleAlmacenado;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleMontar;
import ec.org.inspi.cirev.collection.models.RequerimientoEstado;
import ec.org.inspi.cirev.collection.models.Sexo;
import ec.org.inspi.cirev.collection.models.Subfamilia;
import ec.org.inspi.cirev.collection.models.Subgenero;
import ec.org.inspi.cirev.collection.models.User;
import ec.org.inspi.cirev.collection.models.VoucherMolecular;
import ec.org.inspi.cirev.collection.payload.request.CuracionDetallesRequest;
import ec.org.inspi.cirev.collection.payload.request.CuracionRequest;
import ec.org.inspi.cirev.collection.payload.request.RequerimientoDetallesRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;
import ec.org.inspi.cirev.collection.payload.response.AlmacenadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.CuracionDetallesResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.CuracionResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.MontadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.repositories.CabinetRepository;
import ec.org.inspi.cirev.collection.repositories.ClaseRepository;
import ec.org.inspi.cirev.collection.repositories.DocumentoEvidenciaRepository;
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
import ec.org.inspi.cirev.collection.repositories.RequerimientoDetalleAlmacenadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoDetalleMontadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoDetalleRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoEstadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoRepository;
import ec.org.inspi.cirev.collection.repositories.SexoRepository;
import ec.org.inspi.cirev.collection.repositories.SubfamiliaRepository;
import ec.org.inspi.cirev.collection.repositories.SubgeneroRepository;
import ec.org.inspi.cirev.collection.repositories.UserRepository;
import ec.org.inspi.cirev.collection.repositories.VoucherMolecularRepository;
import ec.org.inspi.cirev.collection.services.CatalogoService;
import ec.org.inspi.cirev.collection.services.CuracionesService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service("procesamientosService")
public class CuracionesServiceImpl implements CuracionesService {

	@Autowired
	private RequerimientoRepository requeRepo;
	@Autowired
	private RequerimientoDetalleRepository requeDetRepo;
	@Autowired
	private ProyectoAreaRepository proyectoRepo;
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private DocumentoEvidenciaRepository docRepo;
	@Autowired
	private RequerimientoEstadoRepository reqEstaRep;
	@Autowired
	private RequerimientoDetalleAlmacenadoRepository reqRegisAlmacenRep;
	@Autowired
	private RequerimientoDetalleMontadoRepository reqRegisMonRep;
	@Autowired
	private FiloRepository filoRepo;
	@Autowired
	private ClaseRepository claseRep;
	@Autowired
	private OrdenRepository ordenRep;
	@Autowired
	private FamiliaRepository familiaRep;
	@Autowired
	private SubfamiliaRepository subfamiliaRep;
	@Autowired
	private GeneroRepository generoRep;
	@Autowired
	private SubgeneroRepository subgeneronRep;
	@Autowired
	private EspecieRepository especieRep;
	@Autowired
	private SexoRepository sexoRep;
	@Autowired
	private IdentificadorDigitadorRepository idenRepo;
	@Autowired
	private MetodoIdentificacionRepository metRepo;
	@Autowired
	private VoucherMolecularRepository vouRepo;
	@Autowired
	private MetodoColectaInmaduroRepository metInm;
	@Autowired
	private MetodoColectaAdultoRepository metAdul;
	@Autowired
	private HabitatRepository habRepo;
	@Autowired
	private IdentificadorDigitadorRepository identRepo;
	@Autowired
	private CatalogoService catServ;
	@Autowired
	private CabinetRepository cabitRepo;

	@Override
	public List<RequerimientoResponseLista> findAll() {
		try {
			List<RequerimientoEstado> ids = reqEstaRep.findAllByStatusId(2);
			List<Requerimiento> requerimientos = new ArrayList<>();
			for (RequerimientoEstado id : ids) {
				Requerimiento req = requeRepo.findById(id.getRequirementId()).get();
				if (req != null)
					requerimientos.add(req);
			}

			List<RequerimientoResponseLista> requeResL = new ArrayList<>();
			RequerimientoResponseLista requeRes;
			for (Requerimiento requerimiento : requerimientos) {
				requeRes = new RequerimientoResponseLista();
				requeRes.setId(requerimiento.getId());
				requeRes.setNumber(requerimiento.getCode());
				requeRes.setEntryDate(calendarToString(requerimiento.getEntryDate()));
				ProyectoArea pa = proyectoRepo.findById(requerimiento.getAreaProjectId()).get();
				requeRes.setAreaProject(pa.getName());
				requeRes.setIsSequenced(requerimiento.getIsSequenced());
				requeRes.setNumberSamples(requerimiento.getNumberContainers());
				if (requerimiento.getRequerimentUserId() != null) {
					User uf = uRepo.findById(requerimiento.getRequerimentUserId());
					requeRes.setRequerimentUser(getName("", uf.getName(), uf.getLastname(), ""));
				}
				if (requerimiento.getReceptionUserId() != null) {
					User uf = uRepo.findById(requerimiento.getReceptionUserId());
					requeRes.setReceptionUser(getName("", uf.getName(), uf.getLastname(), ""));
				}
				requeRes.setEvidence(
						docRepo.findByRequirementIdAndDocumentTypeId(requerimiento.getId(), 1) != null ? true : false);
				requeResL.add(requeRes);
			}
			return requeResL;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getName(String pre, String name, String lastname, String suf) {
		String nombre = "";
		if (pre == null & suf == null) {
			nombre = name + " " + lastname;
		} else if (pre != null & suf == null) {
			nombre = pre + " " + name + " " + lastname;
		} else if (pre == null & suf != null) {
			nombre = name + " " + lastname + " " + suf;
		} else {
			nombre = pre + " " + name + " " + lastname + " " + suf;
		}
		return nombre;
	}

	public Calendar stringToCalendar(String fecha) throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public String calendarToString(Calendar fecha) throws ParseException {
		if (fecha.get(Calendar.DAY_OF_MONTH) < 10 && (fecha.get(Calendar.MONTH) + 1) < 10) {
			return String.valueOf(fecha.get(Calendar.YEAR)) + "-0" + String.valueOf(fecha.get(Calendar.MONTH) + 1)
					+ "-0" + String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		} else if (fecha.get(Calendar.DAY_OF_MONTH) < 10 && (fecha.get(Calendar.MONTH) + 1) > 10) {
			return String.valueOf(fecha.get(Calendar.YEAR)) + "-" + String.valueOf(fecha.get(Calendar.MONTH) + 1) + "-0"
					+ String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		} else if (fecha.get(Calendar.DAY_OF_MONTH) > 10 && (fecha.get(Calendar.MONTH) + 1) < 10) {
			return String.valueOf(fecha.get(Calendar.YEAR)) + "-0" + String.valueOf(fecha.get(Calendar.MONTH) + 1) + "-"
					+ String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		} else {
			return String.valueOf(fecha.get(Calendar.YEAR)) + "-" + String.valueOf(fecha.get(Calendar.MONTH) + 1) + "-"
					+ String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		}
	}

	@Override
	public List<RequerimientoResponseLista> save(CuracionRequest requerimientoRequest) {
		try {
			Calendar fechaActual = Calendar.getInstance();
			Requerimiento requerimiento = new Requerimiento();
			if (requerimientoRequest.getId() != null) {
				requerimiento = requeRepo.findById(requerimientoRequest.getId()).get();
				String[] usersProcess = requerimientoRequest.getProcessingUsersId().split(",");
				requerimiento.setModifiedBy(
						usersProcess != null ? Integer.parseInt(usersProcess[usersProcess.length - 1]) : null);
				requerimiento.setModifiedAt(fechaActual);
			}
			if (requerimientoRequest.getTechnique01Id() != null)
				requerimiento.setTechnique01Id(requerimientoRequest.getTechnique01Id());
			if (requerimientoRequest.getKitReagent01Id() != null)
				requerimiento.setKitReagent01Id(requerimientoRequest.getKitReagent01Id());

			requerimiento = requeRepo.save(requerimiento);
			for (CuracionDetallesRequest detalleReq : requerimientoRequest.getDetails()) {
				RequerimientoDetalle detalle = new RequerimientoDetalle();
				if (detalleReq.getId() != null) {
					detalle = requeDetRepo.findById(detalleReq.getId()).get();
					String[] usersProcess = requerimientoRequest.getProcessingUsersId().split(",");
					requerimiento.setModifiedBy(
							usersProcess != null ? Integer.parseInt(usersProcess[usersProcess.length - 1]) : null);
					detalle.setModifiedAt(fechaActual);
				}
				detalle.setResultProcess01(detalleReq.getProcessingResults01());
				detalle.setObservationProcess01(detalleReq.getObservationResults01());
				detalle.setDateProcess01(
						detalleReq.getDateResults01() != null ? stringToCalendar(detalleReq.getDateResults01()) : null);
				detalle.setResultProcess02(detalleReq.getProcessingResults02());
				detalle.setObservationProcess02(detalleReq.getObservationResults02());
				detalle.setDateProcess02(
						detalleReq.getDateResults02() != null ? stringToCalendar(detalleReq.getDateResults02()) : null);
				detalle.setResultProcess03(detalleReq.getProcessingResults03());
				detalle.setObservationProcess03(detalleReq.getObservationResults03());
				detalle.setDateProcess03(
						detalleReq.getDateResults03() != null ? stringToCalendar(detalleReq.getDateResults03()) : null);
				requeDetRepo.save(detalle);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return findAll();
	}

	@Override
	public CuracionResponseEditar saveStored(List<RequerimientoDetalleAlmacenado> registro) {
		// System.out.println(registro);
		RequerimientoDetalle reqDet = new RequerimientoDetalle();
		Requerimiento req = new Requerimiento();
		RequerimientoDetalleAlmacenado incremental = new RequerimientoDetalleAlmacenado();
		for (RequerimientoDetalleAlmacenado reg : registro) {
			incremental = reqRegisAlmacenRep.findFirstByOrderByIdDesc();
			reqDet = requeDetRepo.findById(reg.getReqDetailId()).get();
			req = requeRepo.findById(reqDet.getRequirementId()).get();
			if (reg.getId() == null) {
				if (reqDet.getNumIndividuals() != null)
					reqDet.setNumIndividuals(
							reqDet.getNumIndividuals() + reg.getMales() + reg.getFemales() + reg.getImmatures());
				else
					reqDet.setNumIndividuals(reg.getMales() + reg.getFemales() + reg.getImmatures());
				if (reqDet.getNumStored() != null)
					reqDet.setNumStored(reqDet.getNumStored() + reg.getMales() + reg.getFemales() + reg.getImmatures());
				else
					reqDet.setNumStored(reg.getMales() + reg.getFemales() + reg.getImmatures());
				requeDetRepo.save(reqDet);
			}
			if (reg.getId() == null && incremental != null) {
				reg.setId(incremental.getId() + 1);
			} else if (reg.getId() == null && incremental == null) {
				reg.setId(1);
			}
			reg.setProjectId(req.getAreaProjectId());
			reg.setCountryId(64);
			reg.setCantonId(reqDet.getCantonId());
			reg.setParroquiaId(reqDet.getParishId());
			reg.setEstadioId(reqDet.isAdult() ? 5 : 12);
			reg.setFechaColecta(reqDet.getCollectionDate());
			reg.setFecha(reg.getFecha());
			reg.setLatitude(reqDet.getLatitude());
			reg.setLogitude(reqDet.getLongitude());
			reqRegisAlmacenRep.save(reg);
		}

		List<RequerimientoDetalleAlmacenado> detallesOld = reqRegisAlmacenRep.findAllByReqDetailId(reqDet.getId());
		List<RequerimientoDetalleAlmacenado> auxDetOld = reqRegisAlmacenRep.findAllByReqDetailId(reqDet.getId());

		for (RequerimientoDetalleAlmacenado detallReq : registro) {
			for (RequerimientoDetalleAlmacenado detalleOld : detallesOld) {
				if (detalleOld.getId().equals(detallReq.getId())) {
					auxDetOld.remove(detalleOld);
				}
			}
		}
		for (RequerimientoDetalleAlmacenado aux : auxDetOld) {
			reqDet.setNumIndividuals(
					reqDet.getNumIndividuals() - aux.getMales() - aux.getFemales() - aux.getImmatures());
			reqDet.setNumStored(reqDet.getNumStored() - aux.getMales() - aux.getFemales() - aux.getImmatures());
			reqRegisAlmacenRep.deleteById(aux.getId());
		}
		return findById(req.getId());
	}

	@Override
	public CuracionResponseEditar saveMount(List<RequerimientoDetalleMontar> registro) {
		// System.out.println(registro);
		RequerimientoDetalleMontar incremental = new RequerimientoDetalleMontar();
		Requerimiento requ = new Requerimiento();
		for (RequerimientoDetalleMontar reg : registro) {
			incremental = reqRegisMonRep.findFirstByOrderByIdDesc();
			if (reg.getId() == null && incremental != null) {
				reg.setId(incremental.getId() + 1);
			} else if (reg.getId() == null && incremental == null) {
				reg.setId(1);
			}
			RequerimientoDetalle reqDet = requeDetRepo.findById(reg.getReqDetailId()).get();
			Requerimiento req = requeRepo.findById(reqDet.getRequirementId()).get();
			requ = req;
			reg.setProjectId(req.getAreaProjectId());
			reg.setCountryId(64);
			reg.setCantonId(reqDet.getCantonId());
			reg.setParroquiaId(reqDet.getParishId());
			reg.setEstadioId(reqDet.isAdult() ? 5 : 12);
			incremental = reqRegisMonRep.findFirstByOrderByCodeVectorDesc();
			reg.setCodeVector(incremental.getCodeVector() + 1);
			reg.setCodeAlfanumerico("ECU");
			reg.setFechaColecta(reqDet.getCollectionDate());
			reg.setLatitude(reqDet.getLatitude());
			reg.setLogitude(reqDet.getLongitude());
			reqRegisMonRep.save(reg);
			if (reqDet.getNumIndividuals() != null)
				reqDet.setNumIndividuals(reqDet.getNumIndividuals() + 1);
			else
				reqDet.setNumIndividuals(1);
			if (reqDet.getNumMount() != null)
				reqDet.setNumMount(reqDet.getNumMount() + 1);
			else
				reqDet.setNumMount(1);
			requeDetRepo.save(reqDet);
		}
		return findById(requ.getId());
	}

	@Override
	public CuracionResponseEditar findById(Integer requerimientoId) {
		try {
			CuracionResponseEditar reqResEdit = new CuracionResponseEditar();
			List<CuracionDetallesResponseEditar> reqResDetEdit = new ArrayList<>();
			CuracionDetallesResponseEditar reqDetEdit;
			Requerimiento req = requeRepo.findById(requerimientoId).get();
			List<RequerimientoDetalle> reqDets = requeDetRepo.findAllByRequirementId(requerimientoId);
			reqResEdit.setId(req.getId());
			reqResEdit.setEntryDate(req.getEntryDate());
			reqResEdit.setAreaProjectId(req.getAreaProjectId());
			ProyectoArea pa = proyectoRepo.findById(req.getAreaProjectId()).get();
			reqResEdit.setAreaProject(pa.getName());
			for (RequerimientoDetalle reqDet : reqDets) {
				reqDetEdit = new CuracionDetallesResponseEditar();
				reqDetEdit.setId(reqDet.getId());
				reqDetEdit.setCode(reqDet.getPlaceCode());
				reqDetEdit.setCollectionDate(calendarToString(reqDet.getCollectionDate()));
				reqDetEdit.setNumberContainersTubes(reqDet.getNumberContainersTubes());
				reqDetEdit.setNumIndividuals(reqDet.getNumIndividuals());
				reqDetEdit.setNumStored(reqDet.getNumStored());
				reqDetEdit.setNumMount(reqDet.getNumMount());
				reqResDetEdit.add(reqDetEdit);
			}
			reqResEdit.setDetails(reqResDetEdit);
			return reqResEdit;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findVoucherById(Integer requerimientoId) {
		try {
			DocumentosEvidencia doc = docRepo.findByRequirementIdAndDocumentTypeId(requerimientoId, 1);
			return doc.getDocument();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String createVoucher(Integer requerimientoId) {
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("requirementId", requerimientoId);

			JasperPrint empReport = JasperFillManager.fillReport(
					JasperCompileManager.compileReport(
							ResourceUtils.getFile("classpath:reports/reporte_proceso.jrxml").getAbsolutePath()),
					parameters // dynamic parameters
					, dataSource.getConnection());

			byte[] pdf = JasperExportManager.exportReportToPdf(empReport);
			String pdfBas64 = Base64.getEncoder().encodeToString(pdf);
			return "data:application/pdf;base64," + pdfBas64;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<RequerimientoResponseLista> saveComprobante(UploadRequest requerimiento) {
		DocumentosEvidencia doc = docRepo.findByRequirementIdAndDocumentTypeId(requerimiento.getId(), 1);
		if (doc != null) {
			doc.setDocument(requerimiento.getEvidence());
			docRepo.save(doc);
			return findAll();
		} else {
			doc = new DocumentosEvidencia();
			DocumentosEvidencia docFirst = docRepo.findFirstByOrderByIdDesc();
			if (docFirst != null)
				doc.setId(docFirst.getId() + 1);
			else
				doc.setId(1);
			doc.setRequirementId(requerimiento.getId());
			doc.setDocument(requerimiento.getEvidence());
			doc.setDocumentTypeId(1);
			doc.setCreatedAt(Calendar.getInstance());
			doc.setCreatedBy(requerimiento.getUserId());
			docRepo.save(doc);
			return findAll();
		}
	}

	@Override
	public List<AlmacenadosResponseEditar> storedById(Integer id) {
		try {
			List<AlmacenadosResponseEditar> almResEdList = new ArrayList<>();
			AlmacenadosResponseEditar almResEd;
			List<RequerimientoDetalleAlmacenado> alamcenadosPre = reqRegisAlmacenRep.findAllByReqDetailId(id);
			for (RequerimientoDetalleAlmacenado almacenado : alamcenadosPre) {
				almResEd = new AlmacenadosResponseEditar();
				almResEd.setId(almacenado.getId());
				/*
				 * Sexo sex = sexoRep.findById(almacenado.getSexoId()).get();
				 * almResEd.setSexoId(sex.getId()); almResEd.setSexoName(sex.getName());
				 */
				Especie esp = especieRep.findById(almacenado.getKindId()).get();
				almResEd.setEspecieId(esp.getId());
				almResEd.setEspecieName(esp.getName());
				Subgenero sugen = subgeneronRep.findById(esp.getSubgeneroId()).get();
				almResEd.setSubgeneroId(sugen.getId());
				almResEd.setSubgeneroName(sugen.getName());
				Genero gen = generoRep.findById(sugen.getGeneroId()).get();
				almResEd.setGeneroId(gen.getId());
				almResEd.setGeneroName(gen.getName());
				Subfamilia subfa = subfamiliaRep.findById(gen.getSubfamiliaId()).get();
				almResEd.setSubfamiliaId(subfa.getId());
				almResEd.setSubfamiliaName(subfa.getName());
				Familia fam = familiaRep.findById(subfa.getFamiliaId()).get();
				almResEd.setFamiliaId(fam.getId());
				almResEd.setFamiliaName(fam.getName());
				Orden orden = ordenRep.findById(fam.getOrdenId()).get();
				almResEd.setOrdenId(orden.getId());
				almResEd.setOrdenName(orden.getName());
				Clase clase = claseRep.findById(orden.getClaseId()).get();
				almResEd.setClaseId(clase.getId());
				almResEd.setClaseName(clase.getName());
				Filo filo = filoRepo.findById(clase.getFiloId()).get();
				almResEd.setFiloId(filo.getId());
				almResEd.setFiloName(filo.getName());
				IdentificadorDigitador idenDig = idenRepo.findById(almacenado.getIdentificadorId()).get();
				almResEd.setIdentificadorId(idenDig.getId());
				almResEd.setIdentificador(idenDig.getName() + " " + idenDig.getLastname());
				almResEd.setFechaActual(calendarToString(almacenado.getIdentificationDate()));
				MetodoIdentificacion metIden = metRepo.findById(almacenado.getMetIdenId()).get();
				almResEd.setMetodoId(metIden.getId());
				almResEd.setMetodoName(metIden.getName());
				if (almacenado.getVoucherId() != null) {
					VoucherMolecular vou = vouRepo.findById(almacenado.getVoucherId()).get();
					almResEd.setVoucherId(vou.getId());
					almResEd.setVoucherName(vou.getName());
				}
				idenDig = idenRepo.findById(almacenado.getDigitadorId()).get();
				almResEd.setDigitadorId(idenDig.getId());
				almResEd.setDigitador(idenDig.getName() + " " + idenDig.getLastname());
				almResEd.setImmatures(almacenado.getImmatures());
				almResEd.setFemales(almacenado.getFemales());
				almResEd.setMales(almacenado.getMales());
				almResEd.setArmario(almacenado.getArmario());
				almResEd.setGaveta(almacenado.getStorageBox());
				almResEd.setObsStored(almacenado.getObsStored());
				almResEdList.add(almResEd);
			}
			return almResEdList;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MontadosResponseEditar> mountedById(Integer id) {
		try {
			List<MontadosResponseEditar> monResEdList = new ArrayList<>();
			MontadosResponseEditar monResEd;
			List<RequerimientoDetalleMontar> montadosPre = reqRegisMonRep.findAllByReqDetailId(id);
			for (RequerimientoDetalleMontar mount : montadosPre) {
				monResEd = new MontadosResponseEditar();
				monResEd.setId(mount.getId());
				Sexo sex = sexoRep.findById(mount.getSexoId()).get();
				monResEd.setSexoId(sex.getId());
				monResEd.setSexoName(sex.getName());
				Especie esp = especieRep.findById(mount.getEspecieId()).get();
				monResEd.setEspecieId(esp.getId());
				monResEd.setEspecieName(esp.getName());
				Subgenero sugen = subgeneronRep.findById(esp.getSubgeneroId()).get();
				monResEd.setSubgeneroId(sugen.getId());
				monResEd.setSubgeneroName(sugen.getName());
				Genero gen = generoRep.findById(sugen.getGeneroId()).get();
				monResEd.setGeneroId(gen.getId());
				monResEd.setGeneroName(gen.getName());
				Subfamilia subfa = subfamiliaRep.findById(gen.getSubfamiliaId()).get();
				monResEd.setSubfamiliaId(subfa.getId());
				monResEd.setSubfamiliaName(subfa.getName());
				Familia fam = familiaRep.findById(subfa.getFamiliaId()).get();
				monResEd.setFamiliaId(fam.getId());
				monResEd.setFamiliaName(fam.getName());
				Orden orden = ordenRep.findById(fam.getOrdenId()).get();
				monResEd.setOrdenId(orden.getId());
				monResEd.setOrdenName(orden.getName());
				Clase clase = claseRep.findById(orden.getClaseId()).get();
				monResEd.setClaseId(clase.getId());
				monResEd.setClaseName(clase.getName());
				Filo filo = filoRepo.findById(clase.getFiloId()).get();
				monResEd.setFiloId(filo.getId());
				monResEd.setFiloName(filo.getName());
				IdentificadorDigitador idenDig = idenRepo.findById(mount.getIdentificadorId()).get();
				monResEd.setIdentificadorId(idenDig.getId());
				monResEd.setIdentificador(idenDig.getName() + " " + idenDig.getLastname());
				if (mount.getFechaIdentificacion() != null) {
					monResEd.setFechaActual(calendarToString(mount.getFechaIdentificacion()));

				}
				MetodoIdentificacion metIden = metRepo.findById(mount.getMetIdenId()).get();
				monResEd.setMetodoId(metIden.getId());
				monResEd.setMetodoName(metIden.getName());
				if (mount.getVoucherId() != null) {
					VoucherMolecular vou = vouRepo.findById(mount.getVoucherId()).get();
					monResEd.setVoucherId(vou.getId());
					monResEd.setVoucherName(vou.getName());
				}
				idenDig = idenRepo.findById(mount.getDigitadorId()).get();
				monResEd.setDigitadorId(idenDig.getId());
				monResEd.setDigitador(idenDig.getName() + " " + idenDig.getLastname());
				if (mount.getFechaEclosion() != null) {
					monResEd.setFechaEclosion(calendarToString(mount.getFechaEclosion()));
				}
				if (mount.getMetColInmId() != null) {
					MetodoColectaInmaduro metColInm = metInm.findById(mount.getMetColInmId()).get();
					monResEd.setMetColInmaId(metColInm.getId());
					monResEd.setMetColInmaName(metColInm.getName());
				}
				monResEd.setTipCria(mount.getTipoCriadero());
				monResEd.setMatCria(mount.getMaterialCriadero());
				if (mount.getHabitatId() != null) {
					Habitat hab = habRepo.findById(mount.getHabitatId()).get();
					monResEd.setHabitatId(hab.getId());
					monResEd.setHabitatName(hab.getName());
				}
				if (mount.getMetColAdulId() != null) {
					MetodoColectaAdulto metColAdul = metAdul.findById(mount.getMetColAdulId()).get();
					monResEd.setMetColAdulId(metColAdul.getId());
					monResEd.setMetColAdulName(metColAdul.getName());
				}
				monResEd.setCodeEcu(mount.getCodeAlfanumerico() + String.format("%07d", (mount.getCodeVector())));
				monResEd.setArmarioId(mount.getArmario());
				Cabinet ca = cabitRepo.findById(mount.getArmario()).get();
				monResEd.setArmarioName(ca.getName());
				monResEd.setGaveta(mount.getGaveta());
				monResEd.setObsMount(mount.getObservaciones());
				monResEdList.add(monResEd);
			}
			return monResEdList;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IdentificadorDigitador> saveIdentificador(IdentificadorDigitador identificador) {
		IdentificadorDigitador lastIden = identRepo.findFirstByOrderByIdDesc();
		identificador.setId(lastIden.getId() + 1);
		identificador.setRolId(3);
		identificador.setActive(true);
		identRepo.save(identificador);
		return catServ.findIdentificador();
	}

	@Override
	public List<IdentificadorDigitador> saveDigitador(IdentificadorDigitador digitador) {
		IdentificadorDigitador lastIden = identRepo.findFirstByOrderByIdDesc();
		digitador.setId(lastIden.getId() + 1);
		digitador.setRolId(2);
		digitador.setActive(true);
		identRepo.save(digitador);
		return catServ.findDigitador();
	}

	@Override
	public String isEnd(Integer id) {
		List<RequerimientoDetalle> reqDets = requeDetRepo.findAllByRequirementId(id);
		for (RequerimientoDetalle reqDet : reqDets) {
			if (reqDet.getNumIndividuals() == null || reqDet.getNumIndividuals() < 1) {
				return "false";
			} 
		}
		return "true";
	}

}
