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
@Table(name = "txn_tb_4_fml", schema = "collection")
public class Familia {
	
	@Id
	@Column(name = "i_fml_id")
	private Integer id;
	@Column(name = "i_ord_id")
	private Integer ordenId;
	@Column(name = "s_fml_nmb")
	private String name;

}
