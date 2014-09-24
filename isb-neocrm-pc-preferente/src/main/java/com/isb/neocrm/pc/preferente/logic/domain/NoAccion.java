/**
 * 
 */
package com.isb.neocrm.pc.preferente.logic.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Indicate when a user dont  have an action r
 * @author ottoabreu
 *
 */
@JsonSerialize
public class NoAccion extends Accion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "The client does not have comercial actions";
	}
	
	

}
