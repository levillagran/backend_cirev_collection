package ec.org.inspi.cirev.collection.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class CuracionRequest {

	private Integer id;
	private Integer technique01Id;
	private Integer kitReagent01Id;
	private Integer technique02Id;
	private Integer kitReagent02Id;
	private Integer technique03Id;
	private Integer kitReagent03Id;
	
	private String processingUsersId;
	
	private List<CuracionDetallesRequest> details;
}
