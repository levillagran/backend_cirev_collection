package ec.org.inspi.cirev.collection.payload.request;

import lombok.Data;

@Data
public class EstadoValidadorRequest {

	private Integer userId;
	private Integer requerimientoId;
	private Integer estadoId;

}
