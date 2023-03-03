package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Subgenero;

@RepositoryRestResource(path="subgeneros")
public interface SubgeneroRepository extends PagingAndSortingRepository<Subgenero, Integer>{
	List<Subgenero> findAllByGeneroId(Integer id);
}
