package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.CantonParroquia;

@RepositoryRestResource(path="requerimientos")
public interface CantonParroquiaRepository extends PagingAndSortingRepository<CantonParroquia, Integer>{
	List<CantonParroquia> findAllByCantonId(Integer cantonId);
}
