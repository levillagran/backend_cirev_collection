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
@Table(name = "opc_tb_o13", schema = "collection")
public class Habitat {
	
	@Id
	@Column(name = "i_o13_id")
	private Integer id;
	@Column(name = "s_o13_nmb")
	private String name;

}
