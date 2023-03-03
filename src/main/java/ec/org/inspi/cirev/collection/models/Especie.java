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
@Table(name = "txn_tb_6_esp", schema = "collection")
public class Especie {
	
	@Id
	@Column(name = "i_esp_id")
	private Integer id;
	@Column(name = "i_sbg_id")
	private Integer subgeneroId;
	@Column(name = "s_esp_nmb")
	private String name;

}
