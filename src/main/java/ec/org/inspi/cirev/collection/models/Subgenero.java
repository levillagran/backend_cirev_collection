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
@Table(name = "txn_tb_5b_sbg", schema = "collection")
public class Subgenero {
	
	@Id
	@Column(name = "i_sbg_id")
	private Integer id;
	@Column(name = "i_gnr_id")
	private Integer generoId;
	@Column(name = "s_sbg_nmb")
	private String name;

}
