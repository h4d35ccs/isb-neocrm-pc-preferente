package com.isb.neocrm.pc.preferente.logic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Clase de dominio correspondiente a la Accion Preferente
 * Author: schamorro
 * Date: 10/09/14.
 */
public class AccionPreferente extends Accion {

	private static final long serialVersionUID = 1515278362498832348L;
    
	 @JsonProperty("indicador")
	    private int indicator;
	    @JsonProperty("reactiva")
	    private int action;
	    @JsonProperty("textoAccion")
	    private String actionText;
	    @JsonProperty("img")
	    private String actionImage;

		public int getIndicator() {
			return indicator;
		}

		public void setIndicator(int indicator) {
			this.indicator = indicator;
		}

		public int getAction() {
			return action;
		}

		public void setAction(int action) {
			this.action = action;
		}


		public String getActionText() {
			return actionText;
		}

		public void setActionText(String actionText) {
			this.actionText = actionText;
		}

		public String getActionImage() {
			return actionImage;
		}

		public void setActionImage(String actionImage) {
			this.actionImage = actionImage;
		}

		@Override
		public String toString() {
			return "Accion [indicator=" + indicator + ", action=" + action
					+ ", actionText=" + actionText + ", actionImage=" + actionImage
					+ "]";
		}
   
}
