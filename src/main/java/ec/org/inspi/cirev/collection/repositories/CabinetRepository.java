package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Cabinet;

@RepositoryRestResource(path="clases")
public interface CabinetRepository extends PagingAndSortingRepository<Cabinet, Integer>{
	List<Cabinet> findAllByActiveTrue();
	//List<Clase> findAllByFiloId(Integer id);
}
