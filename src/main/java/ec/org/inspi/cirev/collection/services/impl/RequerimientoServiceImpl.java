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

/*import ec.org.inspi.cirev.models.Almacenamiento;
import ec.org.inspi.cirev.models.Analisis;
import ec.org.inspi.cirev.models.Canton;*/
import ec.org.inspi.cirev.collection.models.DocumentosEvidencia;
//import ec.org.inspi.cirev.models.Especificacion;
import ec.org.inspi.cirev.collection.models.Estado;
import ec.org.inspi.cirev.collection.models.MetodoColectaAdulto;
import ec.org.inspi.cirev.collection.models.MetodoColectaInmaduro;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.collection.models.Provincia;
import ec.org.inspi.cirev.collection.models.Canton;
import ec.org.inspi.cirev.collection.models.Colector;
/*import ec.org.inspi.cirev.models.Genero;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.models.Provincia;*/
import ec.org.inspi.cirev.collection.models.ProyectoArea;
//import ec.org.inspi.cirev.models.Reactivo;
import ec.org.inspi.cirev.collection.models.Requerimiento;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalle;
import ec.org.inspi.cirev.collection.models.RequerimientoEstado;
import ec.org.inspi.cirev.collection.models.Taxonomia;
import ec.org.inspi.cirev.collection.models.User;
/*import ec.org.inspi.cirev.models.Tecnica;
import ec.org.inspi.cirev.models.TipoMuestra;
import ec.org.inspi.cirev.models.User;*/
import ec.org.inspi.cirev.collection.payload.request.RequerimientoDetallesRequest;
import ec.org.inspi.cirev.collection.payload.request.RequerimientoRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoDetallesResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.repositories.CantonRepository;
import ec.org.inspi.cirev.collection.repositories.ColectorRepository;
/*import ec.org.inspi.cirev.repositories.AlmacenamientoRepository;
import ec.org.inspi.cirev.repositories.AnalisisRepository;
import ec.org.inspi.cirev.repositories.CantonRepository;*/
import ec.org.inspi.cirev.collection.repositories.DocumentoEvidenciaRepository;
//import ec.org.inspi.cirev.repositories.EspecificacionRepository;
import ec.org.inspi.cirev.collection.repositories.EstadoRepository;
import ec.org.inspi.cirev.collection.repositories.MetodoColectaAdultoRepository;
import ec.org.inspi.cirev.collection.repositories.MetodoColectaInmaduroRepository;
import ec.org.inspi.cirev.collection.repositories.ParroquiaRepository;
import ec.org.inspi.cirev.collection.repositories.ProvinciaRepository;
/*import ec.org.inspi.cirev.repositories.GeneroRepository;
import ec.org.inspi.cirev.repositories.ParroquiaRepository;
import ec.org.inspi.cirev.repositories.ProvinciaRepository;*/
import ec.org.inspi.cirev.collection.repositories.ProyectoAreaRepository;
//import ec.org.inspi.cirev.repositories.ReactivoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoDetalleRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoEstadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoRepository;
import ec.org.inspi.cirev.collection.repositories.TaxonomiaRepository;
import ec.org.inspi.cirev.collection.repositories.UserRepository;
import ec.org.inspi.cirev.collection.services.CatalogoService;
/*import ec.org.inspi.cirev.repositories.TecnicaRepository;
import ec.org.inspi.cirev.repositories.TipoMuestraRepository;
import ec.org.inspi.cirev.repositories.UserRepository;*/
import ec.org.inspi.cirev.collection.services.RequerimientoService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service("requerimientoService")
public class RequerimientoServiceImpl implements RequerimientoService {

	@Autowired
	private RequerimientoRepository requeRepo;
	@Autowired
	private RequerimientoDetalleRepository requeDetRepo;
	@Autowired
	private ProyectoAreaRepository proyectoRepo;
	/*
	 * @Autowired private AnalisisRepository anaRepo;
	 * 
	 * @Autowired private TipoMuestraRepository tmRepo;
	 * 
	 * @Autowired private EspecificacionRepository esRepoy;
	 */
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TaxonomiaRepository taxRepo;
	@Autowired
	private ProvinciaRepository provRepo;
	@Autowired
	private CantonRepository cantRepo;
	@Autowired
	private ParroquiaRepository prarrRepo;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private DocumentoEvidenciaRepository docRepo;
	@Autowired
	private RequerimientoEstadoRepository reqEstaRep;
	@Autowired
	private EstadoRepository estaRep;
	@Autowired
	private MetodoColectaAdultoRepository metAdRep;
	@Autowired
	private MetodoColectaInmaduroRepository metInRep;
	@Autowired
	private ColectorRepository colRepo;
	@Autowired
	private CatalogoService catServ;

	@Override
	public List<RequerimientoResponseLista> findAll() {
		try {
			List<Requerimiento> requerimientos = (List<Requerimiento>) requeRepo.findAll();
			List<RequerimientoResponseLista> requeResL = new ArrayList<>();
			RequerimientoResponseLista requeRes;
			for (Requerimiento requerimiento : requerimientos) {
				requeRes = new RequerimientoResponseLista();
				requeRes.setId(requerimiento.getId());
				RequerimientoEstado reqEs = reqEstaRep.findByRequirementId(requerimiento.getId());
				Estado est = estaRep.findById(reqEs.getStatusId()).get();
				requeRes.setStatus(est.getName());
				requeRes.setNumber(requerimiento.getCode());
				requeRes.setEntryDate(calendarToString(requerimiento.getEntryDate()));
				ProyectoArea pa = proyectoRepo.findById(requerimiento.getAreaProjectId()).get();
				requeRes.setAreaProject(pa.getName());
				String an = "";
				if (requerimiento.isCulicidae())
					an = an + "Culicidae, ";
				if (requerimiento.isTriatominae())
					an = an + "Triatominae, ";
				if (requerimiento.isPsychodidae())
					an = an + "Psychodidae, ";
				if (requerimiento.isSiphonaptera())
					an = an + "Siphonaptera, ";
				if (requerimiento.isIxodidae())
					an = an + "Ixodidae, ";
				requeRes.setAnalysis(an);
				requeRes.setIsSequenced(requerimiento.getIsSequenced());
				requeRes.setNumberSamples(requerimiento.getNumberContainers());
				if (requerimiento.getRequerimentUserId() != null) {
					User uf = userRepo.findById(requerimiento.getRequerimentUserId());
					requeRes.setRequerimentUser(getName("", uf.getName(), uf.getLastname(), ""));
				}
				if (requerimiento.getReceptionUserId() != null) {
					User uf = userRepo.findById(requerimiento.getReceptionUserId());
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
		return String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(fecha.get(Calendar.MONTH) + 1)
				+ "-" + String.valueOf(fecha.get(Calendar.YEAR));
	}

	@Override
	public List<RequerimientoResponseLista> save(RequerimientoRequest requerimientoRequest) {
		try {
			Calendar fechaActual = Calendar.getInstance();
			Requerimiento requerimiento = new Requerimiento();
			if (requerimientoRequest.getId() != null) {
				requerimiento = requeRepo.findById(requerimientoRequest.getId()).get();
				requerimiento.setModifiedBy(requerimientoRequest.getReceptionUserId());
				requerimiento.setModifiedAt(fechaActual);
			} else {
				Requerimiento reqId = requeRepo.findFirstByOrderByIdDesc();
				if (reqId != null)
					requerimiento.setId(reqId.getId() + 1);
				else
					requerimiento.setId(1);
				Requerimiento number = requeRepo.findFirstByOrderByNumberDesc();
				if (number != null) {
					requerimiento.setNumber(number.getNumber() + 1);
					requerimiento.setCode("CNVA-" + fechaActual.get(Calendar.YEAR) + "-"
							+ String.format("%03d", (reqId.getId() + 1)));
				} else {
					requerimiento.setNumber(1);
					requerimiento.setCode("CNVA-" + fechaActual.get(Calendar.YEAR) + "-001");
				}
				RequerimientoEstado reqEstado = reqEstaRep.findFirstByOrderByIdDesc();
				if (reqEstado != null)
					reqEstado = reqEstaRep
							.save(new RequerimientoEstado((reqEstado.getId() + 1), requerimiento.getId(), 1));
				else
					reqEstado = reqEstaRep.save(new RequerimientoEstado(1, requerimiento.getId(), 1));
				requerimiento.setCreatedBy(requerimientoRequest.getReceptionUserId());
				requerimiento.setCreatedAt(fechaActual);
			}
			requerimiento.setEntryDate(stringToCalendar(requerimientoRequest.getEntryDate()));
			requerimiento.setRequerimentUserId(requerimientoRequest.getRequerimentUserId());
			requerimiento.setAreaProjectId(requerimientoRequest.getAreaProjectId());
			requerimiento.setCulicidae(requerimientoRequest.getIsCulicidae());
			requerimiento.setTriatominae(requerimientoRequest.getIsTriatominae());
			requerimiento.setPsychodidae(requerimientoRequest.getIsPsychodidae());
			requerimiento.setSiphonaptera(requerimientoRequest.getIsSiphonaptera());
			requerimiento.setIxodidae(requerimientoRequest.getIsIxodidae());
			requerimiento.setImmature(requerimientoRequest.getIsImmatures());
			requerimiento.setAdults(requerimientoRequest.getIsAdults());
			requerimiento.setDry(requerimientoRequest.getIsDry());
			requerimiento.setWet(requerimientoRequest.getIsWet());
			requerimiento.setContaminated(requerimientoRequest.getIsContaminated());
			requerimiento.setObservationRequirement(requerimientoRequest.getObservationRequirement());
			requerimiento.setReceptionUserId(requerimientoRequest.getReceptionUserId());
			int d = 0;
			int w = 0;
			int tc = 0;
			for (RequerimientoDetallesRequest detalleReq : requerimientoRequest.getDetails()) {
				if (detalleReq.getIsDry())
					d = d + Integer.parseInt(detalleReq.getNumberContainersTubes());
				else
					w = w + Integer.parseInt(detalleReq.getNumberContainersTubes());
				tc = tc + Integer.parseInt(detalleReq.getNumberContainersTubes());
			}
			requerimiento.setNumberDry(d);
			requerimiento.setNumberWet(w);
			requerimiento.setNumberContainers(tc);
			requerimiento = requeRepo.save(requerimiento);
			
			List<RequerimientoDetallesRequest> rRs = requerimientoRequest.getDetails();
			int index = 0;
			for (RequerimientoDetallesRequest detalleReq : rRs) {
				RequerimientoDetalle detalle = new RequerimientoDetalle();
				Taxonomia taxo;
				if (detalleReq.getPlaceCode().length() > 0 && detalleReq.getCollectionDate().length() > 0) {
					if (detalleReq.getId() != null) {
						detalle = requeDetRepo.findById(detalleReq.getId()).get();
						detalle.setModifiedBy(requerimientoRequest.getReceptionUserId());
						detalle.setModifiedAt(fechaActual);
					} else {
						RequerimientoDetalle reqDetId = requeDetRepo.findFirstByOrderByIdDesc();
						if (reqDetId != null) {
							detalle.setId(reqDetId.getId() + 1);
							detalleReq.setId(reqDetId.getId() + 1);
							rRs.set(index, detalleReq);
						} else
							detalle.setId(1);
						detalle.setRequirementId(requerimiento.getId());
						RequerimientoDetalle serial = requeDetRepo.findFirstByOrderBySerialDesc();
						if (serial != null)
							detalle.setSerial(serial.getSerial() + 1);
						else
							detalle.setSerial(1);
						taxo = taxRepo.findById(detalleReq.getTaxonomicId()).get();
						detalle.setCode("COL-" + fechaActual.get(Calendar.YEAR) + "-"
								+ taxo.getName().substring(0, 3).toUpperCase() + "-"
								+ String.format("%04d", detalle.getSerial()));
						detalle.setCreatedBy(requerimientoRequest.getReceptionUserId());
						detalle.setCreatedAt(fechaActual);
					}
					detalle.setPlaceCode(detalleReq.getPlaceCode());
					detalle.setCollectionDate(stringToCalendar(detalleReq.getCollectionDate()));
					detalle.setProvinceId(detalleReq.getProvinceId());
					detalle.setCantonId(detalleReq.getCantonId());
					detalle.setParishId(detalleReq.getParishId());
					detalle.setLatitude(detalleReq.getLatitude());
					detalle.setLongitude(detalleReq.getLongitude());
					detalle.setCollectionMethodId(detalleReq.getCollectionMethodId());
					detalle.setCollectorUserId(detalleReq.getCollectorUserId());
					detalle.setTaxonomicId(detalleReq.getTaxonomicId());
					detalle.setAdult(detalleReq.getIsAdult());
					detalle.setDry(detalleReq.getIsDry());
					detalle.setNumberContainersTubes(Integer.parseInt(detalleReq.getNumberContainersTubes()));
					detalle.setObservationContainersDetail(detalleReq.getObservationSampleDetail());
					requeDetRepo.save(detalle);
				}
				index++;
			}
			List<RequerimientoDetalle> detallesOld = requeDetRepo.findAllByRequirementId(requerimiento.getId());
			List<RequerimientoDetalle> auxDetOld = requeDetRepo.findAllByRequirementId(requerimiento.getId());

			for (RequerimientoDetallesRequest detallReq : rRs) {
				for (RequerimientoDetalle detalleOld : detallesOld) {
					if (detalleOld.getId().equals(detallReq.getId()) ) {
						auxDetOld.remove(detalleOld);
					}
				}
			}
			for (RequerimientoDetalle aux : auxDetOld) {
				requeDetRepo.deleteById(aux.getId());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return findAll();
	}

	@Override
	public RequerimientoResponseEditar findById(Integer requerimientoId) {
		try {
			RequerimientoResponseEditar reqResEdit = new RequerimientoResponseEditar();
			List<RequerimientoDetallesResponseEditar> reqResDetEdit = new ArrayList<>();
			RequerimientoDetallesResponseEditar reqDetEdit;
			Requerimiento req = requeRepo.findById(requerimientoId).get();
			List<RequerimientoDetalle> reqDets = requeDetRepo.findAllByRequirementId(requerimientoId);
			reqResEdit.setId(req.getId());
			reqResEdit.setEntryDate(req.getEntryDate());
			reqResEdit.setAreaProjectId(req.getAreaProjectId());
			ProyectoArea pa = proyectoRepo.findById(req.getAreaProjectId()).get();
			reqResEdit.setAreaProject(pa.getName());

			List<Integer> estadioIds = new ArrayList<>();
			if (req.isImmature())
				estadioIds.add(1);
			if (req.isAdults())
				estadioIds.add(2);
			reqResEdit.setEstadioIds(estadioIds);
			List<Integer> medioIds = new ArrayList<>();
			if (req.isDry())
				medioIds.add(1);
			if (req.isWet())
				medioIds.add(2);
			reqResEdit.setMedioIds(medioIds);
			List<Integer> analisisIds = new ArrayList<>();
			if (req.isCulicidae())
				analisisIds.add(1);
			if (req.isTriatominae())
				analisisIds.add(2);
			if (req.isPsychodidae())
				analisisIds.add(3);
			if (req.isSiphonaptera())
				analisisIds.add(4);
			if (req.isIxodidae())
				analisisIds.add(5);
			reqResEdit.setAnalisisIds(analisisIds);
			reqResEdit.setContaminacion(req.isContaminated());

			reqResEdit.setObservationRequirement(req.getObservationRequirement());

			reqResEdit.setRequerimentUserId(req.getRequerimentUserId());
			if (req.getRequerimentUserId() != null) {
				User uf = userRepo.findById(req.getRequerimentUserId());
				reqResEdit.setRequerimentUser(getName(uf.getPrefix(), uf.getName(), uf.getLastname(), uf.getSuffix()));
			}
			reqResEdit.setReceptionUserId(req.getReceptionUserId());
			if (req.getReceptionUserId() != null) {
				User uf = userRepo.findById(req.getReceptionUserId());
				reqResEdit.setReceptionUser(getName(uf.getPrefix(), uf.getName(), uf.getLastname(), uf.getSuffix()));
			}
			for (RequerimientoDetalle reqDet : reqDets) {
				reqDetEdit = new RequerimientoDetallesResponseEditar();
				reqDetEdit.setId(reqDet.getId());
				reqDetEdit.setPlaceCode(reqDet.getPlaceCode());
				reqDetEdit.setCollectionDate(calendarToString(reqDet.getCollectionDate()));
				if (reqDet.getTaxonomicId() != null) {
					reqDetEdit.setTaxonomicId(reqDet.getTaxonomicId());
					Taxonomia tax = taxRepo.findById(reqDet.getTaxonomicId()).get();
					reqDetEdit.setTaxonomic(tax.getName());
				}
				if (reqDet.getProvinceId() != null) {
					reqDetEdit.setProvinceId(reqDet.getProvinceId());
					Provincia prov = provRepo.findById(reqDet.getProvinceId()).get();
					reqDetEdit.setProvince(prov.getName());
				}
				if (reqDet.getCantonId() != null) {
					reqDetEdit.setCantonId(reqDet.getCantonId());
					Canton cant = cantRepo.findById(reqDet.getCantonId()).get();
					reqDetEdit.setCanton(cant.getName());
				}
				if (reqDet.getParishId() != null) {
					reqDetEdit.setParishId(reqDet.getParishId());
					Parroquia parr = prarrRepo.findById(reqDet.getParishId()).get();
					reqDetEdit.setParish(parr.getName());
				}
				reqDetEdit.setLatitude(reqDet.getLatitude());
				reqDetEdit.setLongitude(reqDet.getLongitude());
				reqDetEdit.setState(reqDet.isAdult() ? "Adulto" : "Inmaduro");
				reqDetEdit.setStateId(reqDet.isAdult() ? 2 : 1);
				reqDetEdit.setDry(reqDet.isDry() ? "En seco" : "En humedo");
				reqDetEdit.setDryId(reqDet.isDry() ? 1 : 2);
				reqDetEdit.setCollectionMethodId(reqDet.getCollectionMethodId());
				if (reqDet.isAdult()) {
					MetodoColectaAdulto metodo = metAdRep.findById(reqDet.getCollectionMethodId()).get();
					reqDetEdit.setCollectionMethod(metodo.getName());
				} else {
					MetodoColectaInmaduro metodo = metInRep.findById(reqDet.getCollectionMethodId()).get();
					reqDetEdit.setCollectionMethod(metodo.getName());
				}
				reqDetEdit.setNumberContainersTubes(reqDet.getNumberContainersTubes());
				reqDetEdit.setCollectorUserId(reqDet.getCollectorUserId());
				if (reqDet.getCollectorUserId() != null) {
					Colector pe = colRepo.findById(reqDet.getCollectorUserId()).get();
					reqDetEdit.setCollectorUser(pe.getName() + " " + pe.getLastname());
				}
				reqDetEdit.setObservations(reqDet.getObservationContainersDetail());
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
					JasperCompileManager.compileReport(ResourceUtils
							.getFile("classpath:reports/reporte_registro_coleccion.jrxml").getAbsolutePath()),
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
	public List<Colector> saveColector(Colector colector) {
		Colector lastColector = colRepo.findFirstByOrderByIdDesc();
		colector.setId(lastColector.getId() + 1);
		colRepo.save(colector);
		return catServ.listColectores(colector.getProjectId());
	}

	@Override
	public List<User> requestSave(User solicitante) {
		Calendar calendar = Calendar.getInstance();
		User last = userRepo.findFirstByOrderByIdDesc();
		solicitante.setId(last.getId() + 1);
		if (solicitante.getCode().equals("true")) {
			solicitante.setInternal(true);
			solicitante.setCode(null);
		}
		solicitante.setCreatedAt(calendar);
		solicitante.setCreatedBy(1);
		userRepo.save(solicitante);
		return catServ.findSigningUsersAll(solicitante.isInternal());
	}

	@Override
	public List<ProyectoArea> projectSave(ProyectoArea proyecto) {
		ProyectoArea pr = proyectoRepo.findFirstByOrderByIdDesc();
		proyecto.setId(pr.getId() + 1);
		proyectoRepo.save(proyecto);
		return (List<ProyectoArea>) proyectoRepo.findAll();
	}

}
