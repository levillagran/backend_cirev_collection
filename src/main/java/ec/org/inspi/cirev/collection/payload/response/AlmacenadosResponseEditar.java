package ec.org.inspi.cirev.collection.payload.response;

import lombok.Data;

@Data
public class AlmacenadosResponseEditar {

	private Integer id;
	private Integer idNum;
    private String filoName;
    private Integer filoId;
    private String claseName;
    private Integer claseId;
    private String ordenName;
    private Integer ordenId;
    private String familiaName;
    private Integer familiaId;
    private String subfamiliaName;
    private Integer subfamiliaId;
    private String generoName;
    private Integer generoId;
    private String subgeneroName;
    private Integer subgeneroId;
    private String especieName;
    private Integer especieId;
    private String sexoName;
    private Integer sexoId;
    private String identificador;
    private Integer identificadorId;
    private String fechaActual;
    private String metodoName;
    private Integer metodoId;
    private String voucherName;
    private Integer voucherId;
    private String digitador;
    private Integer digitadorId;
    private Integer immatures;
    private Integer females;
    private Integer males;
    private String armario;
    private String gaveta;
    private String obsStored;
	
}
