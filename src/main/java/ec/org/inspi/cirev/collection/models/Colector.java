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
@Table(name = "crv_tb_clc", schema = "collection")
public class Colector {
	
	@Id
	@Column(name = "i_clc_id")
	private Integer id;
	@Column(name = "i_pry_id")
	private Integer projectId;
	@Column(name = "s_clc_nmb")
	private String name;
	@Column(name = "s_clc_apl")
	private String lastname;
	@Column(name = "active")
	private boolean active;
}
