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

import ec.org.inspi.cirev.collection.models.DocumentosEvidencia;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.collection.models.Provincia;
import ec.org.inspi.cirev.collection.models.ProyectoArea;
import ec.org.inspi.cirev.collection.models.Requerimiento;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalle;
import ec.org.inspi.cirev.collection.models.RequerimientoEstado;
import ec.org.inspi.cirev.collection.models.User;

import ec.org.inspi.cirev.collection.payload.request.RequerimientoDetallesRequest;
import ec.org.inspi.cirev.collection.payload.request.RequerimientoRequest;
import ec.org.inspi.cirev.collection.payload.request.ResultadoRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoDetallesResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.payload.response.ResultadoResponseEditar;
import ec.org.inspi.cirev.collection.repositories.CantonRepository;
import ec.org.inspi.cirev.collection.repositories.DocumentoEvidenciaRepository;
import ec.org.inspi.cirev.collection.repositories.ParroquiaRepository;
import ec.org.inspi.cirev.collection.repositories.ProvinciaRepository;
import ec.org.inspi.cirev.collection.repositories.ProyectoAreaRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoDetalleRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoEstadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoRepository;
import ec.org.inspi.cirev.collection.repositories.UserRepository;
import ec.org.inspi.cirev.collection.services.ResultadoService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service("resultadoService")
public class ResultadoServiceImpl implements ResultadoService {

	@Autowired
	private RequerimientoRepository requeRepo;
	@Autowired
	private RequerimientoDetalleRepository requeDetRepo;
	@Autowired
	private ProyectoAreaRepository proyectoRepo;
	@Autowired
	private ProvinciaRepository provRepo;
	@Autowired
	private CantonRepository cantRepo;
	@Autowired
	private ParroquiaRepository prarrRepo;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private RequerimientoEstadoRepository reqEstaRep;
	@Autowired
	private UserRepository userRepo;
	/*
	 * @Autowired private AnalisisRepository anaRepo;
	 * 
	 * @Autowired private TipoMuestraRepository tmRepo;
	 * 
	 * @Autowired private EspecificacionRepository esRepoy;
	 * 
	 * @Autowired private UsuarioFirmanteRepository ufRepo;
	 * 
	 * @Autowired private TaxonomiaRepository taxRepo;
	 * 
	 * @Autowired private GeneroRepository genRepo;
	 * 
	 * @Autowired private AlmacenamientoRepository alRepo;
	 */
	@Autowired
	private DocumentoEvidenciaRepository docRepo;

	@Override
	public List<RequerimientoResponseLista> findAll() {
		try {
			List<RequerimientoEstado> ids = reqEstaRep.findAllByStatusId(3);
			List<Requerimiento> requerimientos = new ArrayList<>();
			for (RequerimientoEstado id : ids) {
				Requerimiento req = requeRepo.findById(id.getRequirementId()).get();
				if (req != null)
					requerimientos.add(req);
			}
			List<RequerimientoResponseLista> requeResL = new ArrayList<>();
			RequerimientoResponseLista requeRes;
			List<RequerimientoDetalle> reqDets;
			for (Requerimiento requerimiento : requerimientos) {
				requeRes = new RequerimientoResponseLista();
				requeRes.setId(requerimiento.getId());
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
				requeRes.setNumberSamples(requerimiento.getNumberContainers());

				reqDets = requeDetRepo.findAllByRequirementId(requerimiento.getId());
				int numIndi = 0;
				int numAlma = 0;
				int numMont = 0;
				for (RequerimientoDetalle reqDet : reqDets) {
					if (reqDet.getNumIndividuals() != null) {
						numIndi = numIndi + reqDet.getNumIndividuals();
					}
					if (reqDet.getNumStored() != null) {
						numAlma = numAlma + reqDet.getNumStored();
					}
					if (reqDet.getNumMount() != null) {
						numMont = numMont + reqDet.getNumMount();
					}
				}
				requeRes.setNumberIndividuals(numIndi);
				requeRes.setNumberStorages(numAlma);
				requeRes.setNumberMounts(numMont);

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
	public List<RequerimientoResponseLista> save(ResultadoRequest requerimientoRequest) {
		Calendar fechaActual = Calendar.getInstance();
		Requerimiento requerimiento = new Requerimiento();
		if (requerimientoRequest.getId() != null) {
			requerimiento = requeRepo.findById(requerimientoRequest.getId()).get();
			requerimiento.setModifiedBy(requerimientoRequest.getReportByUserId());
			requerimiento.setModifiedAt(fechaActual);
			requerimiento.setObservationsReport(requerimientoRequest.getObservationsReport());
			requerimiento.setAnexos(requerimientoRequest.getAnexos());
			requerimiento.setObservationsClient(requerimientoRequest.getObservationsClient());
			requeRepo.save(requerimiento);
		}
		return findAll();
	}

	@Override
	public ResultadoResponseEditar findById(Integer requerimientoId) {
		ResultadoResponseEditar reqResEdit = new ResultadoResponseEditar();
		Requerimiento req = requeRepo.findById(requerimientoId).get();
		reqResEdit.setObservationsReport(req.getObservationsReport());
		reqResEdit.setAnexos(req.getAnexos());
		reqResEdit.setObservationsClient(req.getObservationsClient());
		return reqResEdit;
	}

	@Override
	public String findVoucherById(Integer requerimientoId) {
		try {
			DocumentosEvidencia doc = docRepo.findByRequirementIdAndDocumentTypeId(requerimientoId, 2);
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
							ResourceUtils.getFile("classpath:reports/reporte_resultados_coleccion.jrxml").getAbsolutePath()),
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
		DocumentosEvidencia doc = docRepo.findByRequirementIdAndDocumentTypeId(requerimiento.getId(), 2);
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
			doc.setDocumentTypeId(2);
			doc.setCreatedAt(Calendar.getInstance());
			doc.setCreatedBy(requerimiento.getUserId());
			docRepo.save(doc);

			return findAll();
		}
	}

}
