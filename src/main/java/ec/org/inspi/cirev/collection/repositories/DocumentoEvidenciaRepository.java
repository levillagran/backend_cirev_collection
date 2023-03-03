package ec.org.inspi.cirev.collection.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ec.org.inspi.cirev.collection.models.DocumentosEvidencia;

@RepositoryRestResource(path="documentosEvidencia")
public interface DocumentoEvidenciaRepository extends PagingAndSortingRepository<DocumentosEvidencia, Integer>{
	DocumentosEvidencia findByRequirementIdAndDocumentTypeId(Integer requerimientoId, Integer tipoId);
	DocumentosEvidencia findFirstByOrderByIdDesc();
}
