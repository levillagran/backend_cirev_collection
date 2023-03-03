package ec.org.inspi.cirev.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Estado;

@RepositoryRestResource(path="estado")
public interface EstadoRepository extends PagingAndSortingRepository<Estado, Integer>{

}
