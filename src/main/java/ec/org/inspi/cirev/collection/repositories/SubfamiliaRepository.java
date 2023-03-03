package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.Subfamilia;

@RepositoryRestResource(path="familias")
public interface SubfamiliaRepository extends PagingAndSortingRepository<Subfamilia, Integer>{
	List<Subfamilia> findAllByFamiliaId(Integer id);
}
