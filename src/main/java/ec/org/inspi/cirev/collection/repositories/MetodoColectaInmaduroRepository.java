package ec.org.inspi.cirev.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.MetodoColectaInmaduro;

@RepositoryRestResource(path="metColInmaduro")
public interface MetodoColectaInmaduroRepository extends PagingAndSortingRepository<MetodoColectaInmaduro, Integer>{
	
}
