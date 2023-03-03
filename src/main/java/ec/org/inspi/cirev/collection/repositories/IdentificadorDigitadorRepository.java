package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.IdentificadorDigitador;

@RepositoryRestResource(path="identificador")
public interface IdentificadorDigitadorRepository extends PagingAndSortingRepository<IdentificadorDigitador, Integer>{
	List<IdentificadorDigitador> findAllByRolId(Integer rolId);
	IdentificadorDigitador findFirstByOrderByIdDesc();
}
