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
@Table(name = "txn_tb_2_cls", schema = "collection")
public class Clase {
	
	@Id
	@Column(name = "i_cls_id")
	private Integer id;
	@Column(name = "i_flo_id")
	private Integer filoId;
	@Column(name = "s_cls_nmb")
	private String name;

}
