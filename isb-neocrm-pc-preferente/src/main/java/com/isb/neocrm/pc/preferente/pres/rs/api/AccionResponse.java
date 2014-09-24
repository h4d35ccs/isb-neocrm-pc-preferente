package com.isb.neocrm.pc.preferente.pres.rs.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isb.neocrm.pc.preferente.logic.domain.Accion;

/**
 * Clase que recopila todos los atributos que van a constituir la respuesta
 * (JSON/XML/Atom/etc.) que devuelve el servicio REST-Accion
 * Author: schamorro
 * Date: 16/09/14.
 */

public class AccionResponse implements Response {
    
	private static final long serialVersionUID = 8039686696076370531L;
    
	@JsonProperty("accionPref")
	private List<Accion> actions;
	
	public void addActionObject(Accion action){
		if(this.actions == null){
			this.actions = new ArrayList<Accion>(1);
		}
		this.actions.add(action);
	}

	public List<Accion> getActions() {
		return actions;
	}

	@Override
	public String toString() {
		return "AccionResponse [actions=" + actions + "]";
	}
    
   
 
}
