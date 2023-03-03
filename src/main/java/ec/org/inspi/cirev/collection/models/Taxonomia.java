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
public class Taxonomia {
	
	@Id
	@Column(name = "i_fml_id")
	private Integer id;
	@Column(name = "i_ord_id")
	private Integer ordenId;
	@Column(name = "s_fml_nmb")
	private String name;
	
	/*@Column(name = "created_at")
	private Calendar createdAt;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "modified_at")
	private Calendar modifiedAt;
	@Column(name = "modified_by")
	private Integer modifiedBy;
	@Column(name = "deleted_at")
	private Calendar deletedAt;
	@Column(name = "deleted_by")
	private Integer deletedBy;*/
}
