package ec.org.inspi.cirev.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.ProyectoArea;

@RepositoryRestResource(path="proyectos")
public interface ProyectoAreaRepository extends PagingAndSortingRepository<ProyectoArea, Integer>{
	ProyectoArea findFirstByOrderByIdDesc();

}
