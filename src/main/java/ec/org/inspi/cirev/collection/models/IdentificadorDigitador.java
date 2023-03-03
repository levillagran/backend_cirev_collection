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
@Table(name = "adm_tb_prs", schema = "collection")
public class IdentificadorDigitador {
	
	@Id
	@Column(name = "i_prs_id")
	private Integer id;
	@Column(name = "i_rol_id")
	private Integer rolId;
	@Column(name = "s_prs_nmb")
	private String name;
	@Column(name = "s_prs_apl")
	private String lastname;
	@Column(name = "active")
	private boolean active;
	
}
