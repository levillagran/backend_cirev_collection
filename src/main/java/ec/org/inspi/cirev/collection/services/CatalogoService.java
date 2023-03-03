package ec.org.inspi.cirev.collection.services;

import java.util.List;


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
import ec.org.inspi.cirev.collection.models.Canton;
import ec.org.inspi.cirev.collection.models.Parroquia;
import ec.org.inspi.cirev.collection.models.Provincia;

public interface CatalogoService {
	public List<ProyectoArea> findProjectsAll();
	public List<User> findSigningUsersAll(boolean isInternal);
	public List<Analisis> findAnalisisAll();
	public List<MetodoColectaAdulto> listMetodoColectaAdulto();
	public List<MetodoColectaInmaduro> listMetodoColectaInmaduro();
	public List<Taxonomia> listTaxones();
	public List<Filo> listFilos();
	public List<Clase> listClases(Integer id);
	public List<Orden> listOrden(Integer id);
	public List<Familia> listFamilia(Integer id);
	public List<Subfamilia> listSubfamilia(Integer id);
	public List<Genero> listGeneros(Integer id);
	public List<Subgenero> listSubgeneros(Integer id);
	public List<Especie> listEspecies(Integer id);
	public List<Sexo> listSexos();
	public List<MetodoIdentificacion> listMetodos();
	public List<VoucherMolecular> listVouchers();
	public List<Habitat> listHabitats();
	public List<Colector> listColectores(Integer id);
	public List<Provincia> findProvinceAll();
	public List<Canton> findCantonAll(Integer provinciaId);
	public List<Parroquia> findParishAll(Integer cantontId);
	public List<IdentificadorDigitador> findIdentificador();
	public List<IdentificadorDigitador> findDigitador();
	public List<Cabinet> listCabinet();
}
