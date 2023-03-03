package ec.org.inspi.cirev.collection.payload.request;

import lombok.Data;

@Data
public class CuracionDetallesRequest {
	
	private Integer id;
	private String processingResults01;
	private String observationResults01;
	private String dateResults01;
	private String processingResults02;
	private String observationResults02;
	private String dateResults02;
	private String processingResults03;
	private String observationResults03;
	private String dateResults03;
	
}
