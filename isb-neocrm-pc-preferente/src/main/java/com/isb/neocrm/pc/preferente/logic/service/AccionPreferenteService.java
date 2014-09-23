package com.isb.neocrm.pc.preferente.logic.service;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;

/**
 * Servicios aplicables a la clase de dominio Accion.
 * Author: schamorro
 * Date: 02/09/14.
 */
public interface AccionPreferenteService {
	public Accion getAccPrefById(String id);
    public Accion getAccReactById(String id);
}
