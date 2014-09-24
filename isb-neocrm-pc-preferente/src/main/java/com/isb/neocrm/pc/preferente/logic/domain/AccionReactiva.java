package com.isb.neocrm.pc.preferente.logic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Clase de dominio correspondiente a la Accion Reactiva
 * Author: schamorro
 * Date: 10/09/14.
 */
public class AccionReactiva extends AccionPreferente {
    private static final long serialVersionUID = 8039686696076370531L;
    

    
    @JsonProperty("descripcAccion")
    private String actionDescription;

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	@Override
	public String toString() {
		
		return "Accion [indicator=" + getIndicator()+ ", action=" + getAction()
				+ ", actionText=" + getActionText() + ", actionImage=" + getActionImage()
				+"actionDescription=" + actionDescription + "]";
	}
   
    

}
