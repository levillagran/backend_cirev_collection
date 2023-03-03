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
@Table(name = "status", schema = "molecular")
public class Estado {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}
