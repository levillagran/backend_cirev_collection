package ec.org.inspi.cirev.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Sexo;

@RepositoryRestResource(path="sexos")
public interface SexoRepository extends PagingAndSortingRepository<Sexo, Integer>{

}
