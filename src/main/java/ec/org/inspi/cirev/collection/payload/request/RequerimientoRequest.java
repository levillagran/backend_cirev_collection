package ec.org.inspi.cirev.collection.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class RequerimientoRequest {

	private Integer id;
	private String entryDate;
	private Integer areaProjectId;
	private Integer analysisId;
	private Integer specificationId;
	private Integer typeSampleId;
	private Boolean isSequenced;
	
	private String observationRequirement;
	private String observationEntry;
	
	private Integer requerimentUserId;	
	private Integer receptionUserId;
	
	private Boolean isCulicidae;
	private Boolean isTriatominae;
	private Boolean isPsychodidae;
	private Boolean isSiphonaptera;
	private Boolean isIxodidae;
	private Boolean isImmatures;
	private Boolean isAdults;
	private Boolean isDry;
	private Boolean isWet;
	private Boolean isContaminated;
	
	private List<RequerimientoDetallesRequest> details;
}
