package ec.org.inspi.cirev.collection.repositories;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.RequerimientoDetalleAlmacenado;

@RepositoryRestResource(path="almacenaso")
public interface RequerimientoDetalleAlmacenadoRepository extends PagingAndSortingRepository<RequerimientoDetalleAlmacenado, Integer>{
	RequerimientoDetalleAlmacenado findFirstByOrderByIdDesc();
	List<RequerimientoDetalleAlmacenado> findAllByReqDetailId(Integer id);
	
}
