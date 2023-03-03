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
@Table(name = "txn_tb_3_ord", schema = "collection")
public class Orden {
	
	@Id
	@Column(name = "i_ord_id")
	private Integer id;
	@Column(name = "i_cls_id")
	private Integer claseId;
	@Column(name = "s_ord_nmb")
	private String name;

}
