package ec.org.inspi.cirev.collection.services;

import java.util.List;

import ec.org.inspi.cirev.collection.payload.response.AlmacenadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.CuracionResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.MontadosResponseEditar;
import ec.org.inspi.cirev.collection.payload.response.RequerimientoResponseLista;
import ec.org.inspi.cirev.collection.models.IdentificadorDigitador;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleAlmacenado;
import ec.org.inspi.cirev.collection.models.RequerimientoDetalleMontar;
import ec.org.inspi.cirev.collection.payload.request.CuracionRequest;
import ec.org.inspi.cirev.collection.payload.request.UploadRequest;

public interface CuracionesService {
	public List<RequerimientoResponseLista> findAll();
	public List<RequerimientoResponseLista> save(CuracionRequest requerimiento);
	public CuracionResponseEditar saveStored(List<RequerimientoDetalleAlmacenado> registro);
	public CuracionResponseEditar saveMount(List<RequerimientoDetalleMontar> registro);
	public CuracionResponseEditar findById(Integer requerimientoId);
	public String findVoucherById(Integer requerimientoId);
	public String createVoucher(Integer requerimientoId);
	public List<RequerimientoResponseLista> saveComprobante(UploadRequest requerimiento);
	public List<AlmacenadosResponseEditar> storedById(Integer id);
	public List<MontadosResponseEditar> mountedById(Integer id);
	public List<IdentificadorDigitador> saveIdentificador(IdentificadorDigitador identificador);
	public List<IdentificadorDigitador> saveDigitador(IdentificadorDigitador digitador);
	public String isEnd(Integer id);
}
