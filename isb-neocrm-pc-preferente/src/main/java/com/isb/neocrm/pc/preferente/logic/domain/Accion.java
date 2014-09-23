package com.isb.neocrm.pc.preferente.logic.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;//ABBR Edit

import javax.xml.bind.annotation.XmlRootElement; //ABBR Edit

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import BeansB8IP.DatosCampania;

import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;


/**
 * Clase de dominio correspondiente a la Accion Preferente/Reactiva
 * Author: schamorro
 * Date: 17/09/14.
 */
@XmlRootElement(name="accion")
public class Accion implements Serializable {
    private static final long serialVersionUID = 8039686696076370531L;
    
    private static final Logger log = LoggerFactory.getLogger(Accion.class);

    private int indicador;
    private int accion;
    private String descripcion_accion;
    private String texto_accion;
    private String imagen_accion;
    
	
	   
    public static Accion AccionPreferenteToAccionFactory(AccPreferenteEntity acc_pref){
    	
    	Accion accionPref = new Accion();
    	DatosCampania datos=new DatosCampania();
    	
    	log.info("Accion Preferente");
    	accionPref.setIndicador(1);
    	accionPref.setAccion(0);
    	accionPref.setDescripcionAccion(acc_pref.getCAMPAGNA());
    	accionPref.setTextoAccion(datos.getDescripcion1() + datos.getDescripcion2() + datos.getDescripcion3() + datos.getDescripcion4() + datos.getDescripcion5() + datos.getDescripcion6() + datos.getDescripcion7() + datos.getDescripcion8() + datos.getDescripcion9() + datos.getDescripcion10() + datos.getDescripcion11() + datos.getDescripcion12() + datos.getDescripcion13() + datos.getDescripcion14() + datos.getDescripcion15() + datos.getDescripcion16() + datos.getDescripcion17() + datos.getDescripcion18() + datos.getDescripcion19() + datos.getDescripcion20());
    	accionPref.setImagenAccion(acc_pref.getIMAGEN());
    	return accionPref;
    }
    
    
    
    public static Accion AccionReactivaToAccionFactory(AccReactivaEntity acc_react){
    	
    	Accion accionReact = new Accion();
    	DatosCampania datos=new DatosCampania();
    	
    	log.info("Accion Reactiva");
    	accionReact.setIndicador(1);
    	accionReact.setAccion(1);
    	accionReact.setDescripcionAccion(acc_react.getDESC_CORTA());
    	accionReact.setTextoAccion(acc_react.getDESC_LARGA());
    	accionReact.setImagenAccion(acc_react.getIMAGEN());
    	return accionReact;
    }
    
    public static Accion SinAccionToAccionFactory(){
    	
    	Accion sin_accion = new Accion();
    	DatosCampania datos=new DatosCampania();
    	
    	log.info("SIN ACCION");
    	sin_accion.setIndicador(0);
    	sin_accion.setAccion(0);
    	sin_accion.setDescripcionAccion("");
    	sin_accion.setTextoAccion("");
    	sin_accion.setImagenAccion("");
    	return sin_accion;
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
