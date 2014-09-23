package com.isb.neocrm.pc.preferente.pres.rs.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;




import com.isb.neocrm.pc.preferente.dao.jpa.impl.AccPreferenteDAOimpl;
import com.isb.neocrm.pc.preferente.pres.rs.impl.AccPreferenteResourceRESTimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Clase que recopila todos los atributos que van a constituir la respuesta
 * (JSON/XML/Atom/etc.) que devuelve el servicio REST-Accion
 * Author: schamorro
 * Date: 16/09/14.
 */
@XmlRootElement(name="accionpref")

public class AccionResponse implements Serializable {
    private static final long serialVersionUID = 8039686696076370531L;

    public AccionResponse() {
    }
    private static final Logger log = LoggerFactory.getLogger(AccionResponse.class);

    
    @XmlElement(name = "indicador")
    private int indicador;
    
    @XmlElement(name = "reactiva")
    private int reactiva;

    @XmlElement(name = "descrip_accion")
    private String descrip_accion;

    @XmlElement(name="texto_accion")
    private String texto_accion;

    @XmlElement(name="imagen")
    private String imagen;

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    
    public int getIndicador() {
        return indicador;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }
	
    public int getReactiva() {
        return reactiva;
    }

    public void setReactiva(int reactiva) {
        this.reactiva = reactiva;
    }

    public String getDes_Accion() {
        return descrip_accion;
    }

    public void setDes_Accion(String descrip_accion) {
        this.descrip_accion = descrip_accion;
    }

    public String getTxt_Accion() {
        return texto_accion;
    }

    public void setTxt_Accion(String texto_accion) {
        this.texto_accion = texto_accion;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
