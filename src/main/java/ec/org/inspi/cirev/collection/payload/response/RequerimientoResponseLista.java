package ec.org.inspi.cirev.collection.payload.response;

import lombok.Data;

@Data
public class RequerimientoResponseLista {

	private Integer id;
	private String status;
	private String number;
	private String entryDate;
	
	private String areaProject;
	private String analysis;
	private Boolean isSequenced;
	private Integer numberSamples;
	private Integer numberIndividuals;
	private Integer numberStorages;
	private Integer numberMounts;
	
	private String requerimentUser;
	
	private String receptionUser;
	private Boolean evidence;


	
}
