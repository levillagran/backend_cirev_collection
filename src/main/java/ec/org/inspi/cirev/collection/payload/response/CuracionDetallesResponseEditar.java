package ec.org.inspi.cirev.collection.payload.response;

import lombok.Data;

@Data
public class CuracionDetallesResponseEditar {

	private Integer id;
	private String code;
	private String collectionDate;
	private Integer numberContainersTubes;
	
	private Integer numIndividuals;
	private Integer numStored;
	private Integer numMount;
	
}
