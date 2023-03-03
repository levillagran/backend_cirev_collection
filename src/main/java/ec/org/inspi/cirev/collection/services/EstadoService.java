package ec.org.inspi.cirev.collection.services;

import java.util.List;

import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.payload.request.EstadoRequest;
import ec.org.inspi.cirev.collection.payload.request.EstadoValidadorRequest;

public interface EstadoService {
	public List<RequerimientoResponseLista> changeStatus(EstadoRequest requerimiento);
	public List<RequerimientoResponseLista> changeStatusValidator(EstadoValidadorRequest requerimiento);
}
