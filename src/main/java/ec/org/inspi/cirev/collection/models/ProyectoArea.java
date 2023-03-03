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
@Table(name = "crv_tb_pry", schema = "collection")
public class ProyectoArea {
	
	@Id
	@Column(name = "i_pry_id")
	private Integer id;
	@Column(name = "s_pry_nmb")
	private String name;
	@Column(name = "ending_year")
	private String year;
	@Column(name = "authorization_number")
	private String authCode;
	@Column(name = "active")
	private boolean active;

}
