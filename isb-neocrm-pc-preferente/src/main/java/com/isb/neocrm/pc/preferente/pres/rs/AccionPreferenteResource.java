package com.isb.neocrm.pc.preferente.pres.rs;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;

/**
 * Interface del servicio REST asociado al recurso: accion.
 * Author: schamorro
 * Date: 16/09/14.
 */

public interface AccionPreferenteResource {
    
	public Accion getAccPrefById(String personType,String personCode);
   
}
