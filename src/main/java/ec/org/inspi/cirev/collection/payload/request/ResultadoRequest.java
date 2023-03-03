package ec.org.inspi.cirev.collection.payload.request;

import lombok.Data;

@Data
public class ResultadoRequest {

	private Integer id;
	private String reportDate;
	
	private String reportResults;
	private String observationsReport;
	private String anexos;
	private String observationsClient;
	
	
	private Integer reportByUserId;
}
