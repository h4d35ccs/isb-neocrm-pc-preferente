package com.isb.neocrm.pc.preferente.pres.rs;

import com.isb.neocrm.pc.preferente.logic.domain.AccionPreferente;
import com.isb.neocrm.pc.preferente.logic.domain.AccionReactiva;

/**
 * Interface del servicio REST asociado al recurso: accion.
 * Author: schamorro
 * Date: 16/09/14.
 */

public interface AccionPreferenteResource {
    public AccionPreferente getAccPrefById(Long id);
    public AccionReactiva getAccReactById(Long id);
}
