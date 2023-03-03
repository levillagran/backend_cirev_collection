/**
 * 
 */
package ec.org.inspi.cirev.collection.models;

/**
 * @author episig := Lenin Villagran
 *
 */
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "opc_tb_o27", schema = "collection")
public class MetodoIdentificacion {
	
	@Id
	@Column(name = "i_o27_id")
	private Integer id;
	@Column(name = "s_o27_nmb")
	private String name;

}
