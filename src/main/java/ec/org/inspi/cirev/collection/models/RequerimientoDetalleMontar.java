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
@Table(name = "vct_tb_cln", schema = "collection")
public class RequerimientoDetalleMontar {
	
	@Id
	@Column(name = "i_cln_id")
	private Integer id;
	@Column(name = "requirement_details_id")
	private Integer reqDetailId;
	@Column(name = "i_pry_id")
	private Integer projectId;
	@Column(name = "i_pais_id")
	private Integer countryId;
	@Column(name = "i_cnt_id")
	private Integer cantonId;
	@Column(name = "i_prq_id")
	private Integer parroquiaId;
	@Column(name = "i_rfr_id")
	private Integer referenciaId;
	@Column(name = "i_psb_id")
	private Integer psb;
	@Column(name = "i_clc_idn_id")
	private Integer identificadorId;
	@Column(name = "i_clc_dgt_id")
	private Integer digitadorId;
	@Column(name = "i_esp_id")
	private Integer especieId;
	@Column(name = "i_o13_id")
	private Integer habitatId;
	@Column(name = "i_o17_id")
	private Integer metColAdulId;
	@Column(name = "i_o18_id")
	private Integer metColInmId;
	@Column(name = "i_o24_id")
	private Integer estadioId;
	@Column(name = "i_o25_id")
	private Integer ubicacionId;
	@Column(name = "i_o26_id")
	private Integer voucherId;
	@Column(name = "i_o27_id")
	private Integer metIdenId;
	@Column(name = "i_o29_id")
	private Integer sexoId;
	@Column(name = "i_cln_csa_nmr")
	private Integer numCasa;
	@Column(name = "i_cln_mst_nmr")
	private Integer numMuestra;
	@Column(name = "i_cln_vct_cdg")
	private Integer codeVector;
	@Column(name = "d_cln_vct_idn_fch")
	private Calendar fechaIdentificacion;
	@Column(name = "d_cln_vct_ecl_fch")
	private Calendar fechaEclosion;
	@Column(name = "s_cln_vct_cdg_alf")
	private String CodeAlfanumerico;
	@Column(name = "d_cln_clt_fch")
	private Calendar FechaColecta;
	@Column(name = "i_cln_clt_hrs_esf")
	private Integer horaColectaEsf;
	@Column(name = "d_cln_clt_inc_fch")
	private Calendar fechaInicioCol;
	@Column(name = "d_cln_clt_fnl_fch")
	private Calendar fechaFinCol;
	@Column(name = "d_cln_clt_hra")
	private Calendar horaColecta;
	@Column(name = "s_cln_clt_ant_cdg")
	private String codeAnterior;
	@Column(name = "d_cln_rgs_mdf")
	private Calendar registroModificado;
	@Column(name = "d_cln_bd_dgt_fch")
	private Calendar fecha;
	@Column(name = "longitude")
	private double logitude;
	@Column(name = "latitude")
	private double latitude;
	@Column(name = "f_cln_alt")
	private double altitud;
	@Column(name = "f_cln_sln")
	private Integer salon;
	@Column(name = "s_cln_ecu_ant_cdg")
	private String codeAnteriorEcu;
	@Column(name = "s_cln_crd_tpo")
	private String tipoCriadero;
	@Column(name = "s_cln_crd_mtr")
	private String materialCriadero;
	@Column(name = "s_cln_obs")
	private String observaciones;
	@Column(name = "h_cln_fts")
	private String fotos;
	@Column(name = "f42")
	private Integer f42;
	@Column(name = "s_cln_shl")
	private Integer armario;
	@Column(name = "s_cln_box")
	private String gaveta;
	
}
