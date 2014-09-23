package com.isb.neocrm.pc.preferente.dao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad en BBDD de la Acción Preferente.
 * Author: schamorro
 * Date: 16/09/14.
 */



@Entity
@Table(name = "PC_ACC_REACT", schema="DESNEOC")
public class AccReactivaEntity implements Serializable {
	
	
	//IDEMPR---CHAR(4 BYTE)
	public String getIDEMPR() {
		return idempr;
	}
	public void setIDEMPR(String idempr) {
		this.idempr = idempr;
	}
	
	
	//TIPOPERS---CHAR(1 BYTE)
	public String getTIPOPERS() {
		return tipopers;
	}
	public void setTIPOPERS(String tipopers) {
		this.tipopers = tipopers;
	}
	
	
	//CODPERS---INT
	public Integer getCODPERS() {
		return codpers;
	}
	public void setCODPERS(Integer codpers) {
		this.codpers = codpers;
	}
	
	
	//CODOFERTA---CHAR(15 BYTE)
	public String getCODOFERTA() {
		return codoferta;
	}
	public void setCODOFERTA(String codoferta) {
		this.codoferta = codoferta;
	}
	
	
	//DESC_CORTA---CHAR(50 BYTE)
	public String getDESC_CORTA() {
		return desc_corta;
	}
	public void setDESC_CORTA(String desc_corta) {
		this.desc_corta = desc_corta;
	}
		
	
	//DESC_LARGA---VARCHAR2(1000 BYTE)
	public String getDESC_LARGA() {
		return desc_larga;
	}
	public void setDESC_LARGA(String desc_larga) {
		this.desc_larga = desc_larga;
	}
		
	
	//IMAGEN---VARCHAR2(1500 BYTE)
	public String getIMAGEN() {
		return imagen;
	}
	public void setIMAGEN(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//IDEMPR---CHAR(4 BYTE)
	@Column(name="IDEMPR")
	private String idempr;
		
	//TIPOPERS---CHAR(1 BYTE)
	@Id
	@Column(name="TIPOPERS")
	private String tipopers;
	
	//CODPERS---INT
	@Id
	@Column(name="CODPERS")
	private int codpers;
	
	//CODOFERTA---CHAR(15 BYTE)
	@Column(name="CODOFERTA")
	private String codoferta;
		
	//DESC_CORTA---CHAR(50 BYTE)
	@Column(name="DESC_CORTA")
	private String desc_corta;
		
	//DESC_LARGA---VARCHAR2(1000 BYTE)
	@Column(name="DESC_LARGA")
	private String desc_larga;
	
	//IMAGEN---VARCHAR2(1500 BYTE)
	@Column(name="IMAGEN")
	private String imagen;
	
	
	
	
	
	@Override
	public String toString() {
		return " [CODOFERTA:" + codoferta + ", TIPOPERS:" + tipopers + ", CODPERS:" + codpers + "]";
	}
}
