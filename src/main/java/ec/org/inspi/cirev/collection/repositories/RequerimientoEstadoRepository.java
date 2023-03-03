package ec.org.inspi.cirev.collection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.RequerimientoEstado;

@RepositoryRestResource(path="requerimientosEstados")
public interface RequerimientoEstadoRepository extends PagingAndSortingRepository<RequerimientoEstado, Integer>{
	RequerimientoEstado findFirstByOrderByIdDesc();
	List<RequerimientoEstado> findAllByStatusId(Integer estadoId);
	RequerimientoEstado findByRequirementId(Integer requerimientoId);
}
