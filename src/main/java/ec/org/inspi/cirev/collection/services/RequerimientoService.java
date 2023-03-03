package ec.org.inspi.cirev.collection.services;

import java.util.List;

import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.models.Colector;
import ec.org.inspi.cirev.collection.models.ProyectoArea;
import ec.org.inspi.cirev.collection.models.User;
import ec.org.inspi.cirev.collection.payload.request.RequerimientoRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;

public interface RequerimientoService {
	public List<RequerimientoResponseLista> findAll();
	public List<RequerimientoResponseLista> save(RequerimientoRequest requerimiento);
	public RequerimientoResponseEditar findById(Integer requerimientoId);
	public String findVoucherById(Integer requerimientoId);
	public String createVoucher(Integer requerimientoId);
	public List<RequerimientoResponseLista> saveComprobante(UploadRequest requerimiento);
	public List<Colector> saveColector(Colector colector);
	public List<User> requestSave(User solicitante);
	public List<ProyectoArea> projectSave(ProyectoArea proyecto);
}
