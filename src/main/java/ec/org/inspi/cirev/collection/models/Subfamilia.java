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
@Table(name = "txn_tb_4b_sbf", schema = "collection")
public class Subfamilia {
	
	@Id
	@Column(name = "i_sbf_id")
	private Integer id;
	@Column(name = "i_fml_id")
	private Integer familiaId;
	@Column(name = "s_sbf_nmb")
	private String name;

}
