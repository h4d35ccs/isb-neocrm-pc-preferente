package com.isb.neocrm.pc.preferente.logic.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement; //ABBR Edit

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BeansB8IP.DatosCampania;

import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;


/**
 * Clase de dominio correspondiente a la Accion Reactiva
 * Author: schamorro
 * Date: 10/09/14.
 */
@XmlRootElement(name="accreact")
public class AccionReactiva implements Serializable {
    private static final long serialVersionUID = 8039686696076370531L;
    
    private static final Logger log = LoggerFactory.getLogger(AccionReactiva.class);

    private int indicador;
    private int accion;
    private String descripcion_accion;
    private String texto_accion;
    private String imagen_accion;
    
	
	   
    public static AccionReactiva AccionReactivaToClientFactory(AccReactivaEntity acc_react){
    	
    	AccionReactiva accionReact = new AccionReactiva();
    	DatosCampania datos=new DatosCampania();
    	
    	log.info("Accion Reactiva");
    	accionReact.setIndicador(1);
    	accionReact.setAccion(0); //Indica que la accion es REACTIVA
    	accionReact.setDescripcionAccion(acc_react.getDESC_CORTA());
    	accionReact.setTextoAccion(acc_react.getDESC_LARGA());
    	accionReact.setImagenAccion(acc_react.getIMAGEN());
    	return accionReact;
    }
    
        
    public Integer getIndicador() {
		return indicador;
	}
	public void setIndicador(Integer indicador) {
		this.indicador = indicador;
	}
	
	public Integer getAccion() {
		return accion;
	}
	public void setAccion(Integer accion) {
		this.accion = accion;
	}
	
	public String getDescripcionAccion() {
		return descripcion_accion;
	}
	public void setDescripcionAccion(String descripcion_accion) {
		this.descripcion_accion = descripcion_accion;
	}
	public String getTextoAccion() {
		return texto_accion;
	}
	public void setTextoAccion(String texto_accion) {
		this.texto_accion = texto_accion;
	}
	public String getImagenAccion() {
		return imagen_accion;
	}
	public void setImagenAccion(String imagen_accion) {
		this.imagen_accion = imagen_accion;
	}
	
	
	/**
    * Always treat de-serialization as a full-blown constructor, by validating
    * the final state of the de-serialized object.
    */
    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException {
        
        aInputStream.defaultReadObject();
    }
     
    /**
    * This is the default implementation of writeObject. Customise if
    * necessary.
    */
    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException {
        
        aOutputStream.defaultWriteObject();
    }
}
