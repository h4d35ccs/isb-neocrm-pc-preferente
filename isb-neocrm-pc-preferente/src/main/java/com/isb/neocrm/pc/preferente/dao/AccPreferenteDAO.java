package com.isb.neocrm.pc.preferente.dao;

import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;



/**
 * DAO de las Acciones Preferentes/Acciones Reactivas.
 * Author: schamorro
 * Date: 16/09/14.
 */
public interface AccPreferenteDAO {
    public AccPreferenteEntity getAccionPreferente(String personType, int personCode);
    public AccReactivaEntity getAccionReactiva(String personType, int personCode);
}
