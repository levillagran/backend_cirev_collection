package ec.org.inspi.cirev.collection.repositories;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.RequerimientoDetalleMontar;

@RepositoryRestResource(path="montado")
public interface RequerimientoDetalleMontadoRepository extends PagingAndSortingRepository<RequerimientoDetalleMontar, Integer>{
	RequerimientoDetalleMontar findFirstByOrderByIdDesc();
	RequerimientoDetalleMontar findFirstByOrderByCodeVectorDesc();
	List<RequerimientoDetalleMontar> findAllByReqDetailId(Integer id);
}
