/**
 * 
 */
package ec.org.inspi.cirev.collection.models;

/**
 * @author episig := Lenin Villagran
 *
 */
import lombok.Data;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "requirements", schema = "collection")
public class Requerimiento {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "number")
	private Integer number;
	@Column(name = "code")
	private String code;
	@Column(name = "entry_date")
	private Calendar entryDate;
	@Column(name = "processing_date")
	private Calendar processingDate;
	@Column(name = "report_date")
	private Calendar reportDate;
	@Column(name = "area_project_id")
	private Integer areaProjectId;
	@Column(name = "analysis_id")
	private Integer analysisId;
	@Column(name = "is_sequenced")
	private Boolean isSequenced;
	@Column(name = "type_sample_id")
	private Integer typeSampleId;
	@Column(name = "number_containers")
	private Integer numberContainers;
	@Column(name = "number_dry")
	private Integer numberDry;
	@Column(name = "number_wet")
	private Integer numberWet;
	@Column(name = "specification_id")
	private Integer specificationId;
	@Column(name = "reason_unaccepted_samples")
	private String reasonUnacceptedSamples;
	@Column(name = "observation_requirement")
	private String observationRequirement;
	@Column(name = "observation_entry")
	private String observationEntry;
	@Column(name = "report_results")
	private String reportResults;
	@Column(name = "observations_report")
	private String observationsReport;
	@Column(name = "anexos")
	private String anexos;
	@Column(name = "observations_client")
	private String observationsClient;
	@Column(name = "report_by_user_id")
	private Integer reportByUserId;
	@Column(name = "requeriment_user_id")
	private Integer requerimentUserId;
	@Column(name = "technique_01_id")
	private Integer technique01Id;
	@Column(name = "kit_reagent_01_id")
	private Integer kitReagent01Id;
	@Column(name = "reception_user_id")
	private Integer receptionUserId;
	@Column(name = "processing_users_id")
	private String processingUsersId;
	@Column(name = "validator_user_id")
	private Integer validatorUserId;
	@Column(name = "approval_user_id")
	private Integer approvalUserId;
	@Column(name = "observation_shipping")
	private String observationShipping;
	@Column(name = "observation_reception")
	private String observationReception;
	@Column(name = "shipping_date")
	private Calendar shippingDate;
	@Column(name = "reception_date")
	private Calendar receptionDate;
	
	@Column(name = "is_culicidae")
	private boolean isCulicidae;
	@Column(name = "is_triatominae")
	private boolean isTriatominae;
	@Column(name = "is_psychodidae")
	private boolean isPsychodidae;
	@Column(name = "is_siphonaptera")
	private boolean isSiphonaptera;
	@Column(name = "is_ixodidae")
	private boolean isIxodidae;
	@Column(name = "is_adults")
	private boolean isAdults;
	@Column(name = "is_immature")
	private boolean isImmature;
	@Column(name = "is_dry")
	private boolean isDry;
	@Column(name = "is_wet")
	private boolean isWet;
	@Column(name = "is_contaminated")
	private boolean isContaminated;
	
	@Column(name = "created_at")
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
	private Integer deletedBy;
}
