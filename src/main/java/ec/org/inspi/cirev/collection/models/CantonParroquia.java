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
@Table(name = "cantons_parishes", schema = "geography")
public class CantonParroquia {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "canton_id")
	private Integer cantonId;
	@Column(name = "parish_id")
	private Integer parishId;
}
