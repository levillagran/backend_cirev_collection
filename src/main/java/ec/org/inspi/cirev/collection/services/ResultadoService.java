package ec.org.inspi.cirev.collection.services;

import java.util.List;

import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.payload.response.ResultadoResponseEditar;
import ec.org.inspi.cirev.collection.payload.request.ResultadoRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;

public interface ResultadoService {
	public List<RequerimientoResponseLista> findAll();
	public List<RequerimientoResponseLista> save(ResultadoRequest requerimiento);
	public ResultadoResponseEditar findById(Integer requerimientoId);
	public String findVoucherById(Integer requerimientoId);
	public String createVoucher(Integer requerimientoId);
	public List<RequerimientoResponseLista> saveComprobante(UploadRequest requerimiento);
}
