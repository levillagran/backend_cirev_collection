package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Taxonomia;

@RepositoryRestResource(path="taxonomias")
public interface TaxonomiaRepository extends PagingAndSortingRepository<Taxonomia, Integer>{
	List<Taxonomia> findAllByOrdenId(Integer ordenId);
}
