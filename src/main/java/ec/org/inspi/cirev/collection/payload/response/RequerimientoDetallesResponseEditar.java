package ec.org.inspi.cirev.collection.payload.response;

import lombok.Data;

@Data
public class RequerimientoDetallesResponseEditar {

	private Integer id;
	private String placeCode;
	private String collectionDate;
	private Integer taxonomicId;
	private String taxonomic;
	private Integer provinceId;
	private String province;
	private Integer cantonId;
	private String canton;
	private Integer parishId;
	private String parish;
	private double latitude;
	private double longitude;
	
	private String state;
	private Integer stateId;
	private String collectionMethod;
	private Integer collectionMethodId;
	private String dry;
	private Integer dryId;
	private Integer numberContainersTubes;
	private String collectorUser;
	private Integer collectorUserId;
	private String observations;
	
}
