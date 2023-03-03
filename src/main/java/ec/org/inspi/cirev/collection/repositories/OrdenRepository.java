package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Orden;

@RepositoryRestResource(path="orden")
public interface OrdenRepository extends PagingAndSortingRepository<Orden, Integer>{
	List<Orden> findAllByClaseId(Integer id);
}
