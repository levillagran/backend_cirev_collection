package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Especie;

@RepositoryRestResource(path="especies")
public interface EspecieRepository extends PagingAndSortingRepository<Especie, Integer>{
	List<Especie> findAllBySubgeneroId(Integer id);
}
