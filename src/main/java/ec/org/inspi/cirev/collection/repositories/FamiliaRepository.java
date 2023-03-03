package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Familia;

@RepositoryRestResource(path="familias")
public interface FamiliaRepository extends PagingAndSortingRepository<Familia, Integer>{
	List<Familia> findAllByOrdenId(Integer id);
}
