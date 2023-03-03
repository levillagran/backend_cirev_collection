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
@Table(name = "txn_tb_5_gnr", schema = "collection")
public class Genero {
	
	@Id
	@Column(name = "i_gnr_id")
	private Integer id;
	@Column(name = "i_sbf_id")
	private Integer subfamiliaId;
	@Column(name = "s_gnr_nmb")
	private String name;

}
