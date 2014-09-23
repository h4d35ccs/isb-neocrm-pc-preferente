package com.isb.neocrm.pc.preferente.logic.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.neocrm.pc.preferente.dao.AccPreferenteDAO;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccPreferenteEntity;
import com.isb.neocrm.pc.preferente.dao.jpa.entity.AccReactivaEntity;
import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.service.AccionPreferenteService;

/**
 * Implementación del servicio de Accion Preferente.
 * Author: schamorro
 * Date: 16/09/14.
 */
@Service("accprefService")
public class AccionPreferenteServiceImpl implements AccionPreferenteService {

	
	private static final Logger log = LoggerFactory.getLogger(AccionPreferenteServiceImpl.class);
	
	@Autowired
	private AccPreferenteDAO accPrefDao;

	public Accion getAccPrefById(String id) {
		
		log.info("Implementación del Servicio");
		AccPreferenteEntity entity_pref = accPrefDao.getAccionPreferente(id);
		
		if (entity_pref.getIDEMPR() == null)
		{
			AccReactivaEntity entity_react = accPrefDao.getAccionReactiva(id);
			
			if (entity_react.getIDEMPR() == null)
			{
				return	Accion.SinAccionToAccionFactory();
			}
			return	Accion.AccionReactivaToAccionFactory(entity_react);
		}
		return	Accion.AccionPreferenteToAccionFactory(entity_pref);
	}
	
	public Accion getAccReactById(String id) {
		
		AccReactivaEntity entity_react = accPrefDao.getAccionReactiva(id);
		return	Accion.AccionReactivaToAccionFactory(entity_react);
	}
}
