package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Clase;

@RepositoryRestResource(path="clases")
public interface ClaseRepository extends PagingAndSortingRepository<Clase, Integer>{
	List<Clase> findAllByFiloId(Integer id);
}
