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
@Table(name = "txn_tb_1_flo", schema = "collection")
public class Filo {
	
	@Id
	@Column(name = "i_flo_id")
	private Integer id;
	@Column(name = "s_flo_nmb")
	private String name;

}
