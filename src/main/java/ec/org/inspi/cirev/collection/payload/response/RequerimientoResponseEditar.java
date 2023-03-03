package ec.org.inspi.cirev.collection.payload.response;

import java.util.List;

import java.util.Calendar;

import lombok.Data;

@Data
public class RequerimientoResponseEditar {

	private Integer id;
	private Calendar entryDate;
	private String areaProject;
	private Integer areaProjectId;

	private List<Integer> estadioIds;
	private List<Integer> medioIds;
	private Boolean contaminacion;
	private List<Integer> analisisIds;
	private String observationRequirement;
	//private String observationEntry;
	
	private String requerimentUser;
	private Integer requerimentUserId;
	
	private String receptionUser;
	private Integer receptionUserId;
	
	private List<RequerimientoDetallesResponseEditar> details;
	

}
