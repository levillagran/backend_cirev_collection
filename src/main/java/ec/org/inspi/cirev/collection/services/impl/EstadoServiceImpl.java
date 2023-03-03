package ec.org.inspi.cirev.collection.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ec.org.inspi.cirev.collection.models.Requerimiento;
import ec.org.inspi.cirev.collection.models.RequerimientoEstado;
import ec.org.inspi.cirev.collection.payload.request.EstadoRequest;
import ec.org.inspi.cirev.collection.payload.request.EstadoValidadorRequest;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.repositories.RequerimientoEstadoRepository;
import ec.org.inspi.cirev.collection.repositories.RequerimientoRepository;
import ec.org.inspi.cirev.collection.services.CuracionesService;
//import ec.org.inspi.cirev.collection.services.AprobacionesService;
import ec.org.inspi.cirev.collection.services.EstadoService;
import ec.org.inspi.cirev.collection.services.RequerimientoService;

@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private RequerimientoEstadoRepository reqEstaRep;
	@Autowired
	private RequerimientoService reqSer;
	@Autowired
	private RequerimientoRepository reqRep;
	@Autowired
	private CuracionesService curSrv;
	// @Autowired
	// private AprobacionesService apSer;

	@Override
	public List<RequerimientoResponseLista> changeStatus(EstadoRequest requerimiento) {
		Calendar fechaActual = Calendar.getInstance();
		RequerimientoEstado reqEs = reqEstaRep.findById(requerimiento.getRequerimientoId()).get();
		reqEs.setStatusId(requerimiento.getEstadoId());
		reqEs = reqEstaRep.save(reqEs);
		if (requerimiento.getEstadoId() == 3) {
			Requerimiento req = reqRep.findById(reqEs.getRequirementId()).get();
			req.setReportDate(fechaActual);
			reqRep.save(req);
			return curSrv.findAll();
		} else {
			return reqSer.findAll();
		}
	}

	@Override
	public List<RequerimientoResponseLista> changeStatusValidator(EstadoValidadorRequest requerimiento) {
		RequerimientoEstado reqEs = reqEstaRep.findById(requerimiento.getRequerimientoId()).get();
		Requerimiento req = reqRep.findById(requerimiento.getRequerimientoId()).get();
		reqEs.setStatusId(requerimiento.getEstadoId());
		reqEstaRep.save(reqEs);
		req.setValidatorUserId(requerimiento.getUserId());
		reqRep.save(req);
		return null; // apSer.findAll(requerimiento.getUserId());
	}

}
