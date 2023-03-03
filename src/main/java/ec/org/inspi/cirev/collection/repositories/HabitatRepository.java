package ec.org.inspi.cirev.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Habitat;

@RepositoryRestResource(path="habitad")
public interface HabitatRepository extends PagingAndSortingRepository<Habitat, Integer>{

}
