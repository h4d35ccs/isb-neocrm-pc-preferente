package com.isb.neocrm.pc.preferente.dao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad en BBDD de la Acción Preferente. Author: schamorro Date: 16/09/14.
 */

@Entity
@Table(name = "PC_ACC_PREF")
@NamedQueries({ @NamedQuery(name = "findAccionPreferente", query = "SELECT E FROM AccPreferenteEntity E WHERE E.tipopers = :TIPOPERS AND E.codpers = :CODPERS AND E.codclase = :CODCLASE AND E.idtipeve = :IDTIPEVE AND E.idsubeve = :IDSUBEVE") })
public class AccPreferenteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// IDEMPR---CHAR(4 BYTE)
	@Column(name = "IDEMPR")
	private String idempr;

	// CODCLASE---CHAR(1 BYTE)
	@Column(name = "CODCLASE")
	private String codclase;

	// IDTIPEVE---CHAR(3 BYTE)
	@Column(name = "IDTIPEVE")
	private String idtipeve;

	// IDSUBEVE---CHAR(3 BYTE)
	@Column(name = "IDSUBEVE")
	private String idsubeve;

	// TIPOPERS---CHAR(1 BYTE)
	@Id
	@Column(name = "TIPOPERS")
	private String tipopers;

	// CODPERS---INT
	@Id
	@Column(name = "CODPERS")
	private int codpers;

	// CAMPAGNA---CHAR(10 BYTE)
	@Column(name = "CAMPAGNA")
	private String campagna;

	// IMAGEN---VARCHAR2(1500 BYTE)
	@Column(name = "IMAGEN")
	private String imagen;
	@Transient
	private String longDescription;

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	// IDEMPR---CHAR(4 BYTE)
	public String getIDEMPR() {
		return idempr;
	}

	public void setIDEMPR(String idempr) {
		this.idempr = idempr;
	}

	// CODCLASE---CHAR(1 BYTE)
	public String getCODCLASE() {
		return codclase;
	}

	public void setCODCLASE(String codclase) {
		this.codclase = codclase;
	}

	// IDTIPEVE---CHAR(3 BYTE)
	public String getIDTIPEVE() {
		return idtipeve;
	}

	public void setIDTIPEVE(String idtipeve) {
		this.idtipeve = idtipeve;
	}

	// IDSUBEVE---CHAR(3 BYTE)
	public String getIDSUBEVE() {
		return idsubeve;
	}

	public void setIDSUBEVE(String idsubeve) {
		this.idsubeve = idsubeve;
	}

	// TIPOPERS---CHAR(1 BYTE)
	public String getTIPOPERS() {
		return tipopers;
	}

	public void setTIPOPERS(String tipopers) {
		this.tipopers = tipopers;
	}

	// CODPERS---INT
	public Integer getCODPERS() {
		return codpers;
	}

	public void setCODPERS(Integer codpers) {
		this.codpers = codpers;
	}

	// CAMPAGNA---CHAR(10 BYTE)
	public String getCAMPAGNA() {
		return campagna;
	}

	public void setCAMPAGNA(String campagna) {
		this.campagna = campagna;
	}

	// IMAGEN---VARCHAR2(1500 BYTE)
	public String getIMAGEN() {
		return imagen;
	}

	public void setIMAGEN(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return " [CAMPAGNA:" + campagna + ", TIPOPERS:" + tipopers
				+ ", CODPERS:" + codpers + "]";
	}
}
