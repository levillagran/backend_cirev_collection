/**
 * 
 */
package ec.org.inspi.cirev.collection.payload.request;

/**
 * @author episig := Lenin Villagran
 *
 */

import java.util.Calendar;

import lombok.Data;

@Data
public class RequerimientoDetalleMontarRequest {
	
	private Integer id;
	private Integer reqDetailId;
	private Integer identificadorId;
	private Integer digitadorId;
	private Integer especieId;
	private Integer habitatId;
	private Integer metColAdulId;
	private Integer metColInmId;
	private Integer estadioId;
	private Integer voucherId;
	private Integer metIdenId;
	private Integer sexoId;
	private Calendar fechaIdentificacion;
	private Calendar fechaEclosion;
	private String tipoCriadero;
	private String metodoCriadero;
	private String observaciones;
	private String armario;
	private String gaveta;
	
}
