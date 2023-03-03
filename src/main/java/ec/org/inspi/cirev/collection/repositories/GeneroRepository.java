package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Genero;

@RepositoryRestResource(path="generos")
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Integer>{
	List<Genero> findAllBySubfamiliaId(Integer id);
}
