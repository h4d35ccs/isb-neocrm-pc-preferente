package com.isb.neocrm.pc.preferente.pres.rs.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.logic.service.AccionPreferenteService;
import com.isb.neocrm.pc.preferente.pres.rs.CommonResource;

/**
 * Implementación del servicio REST
 * Author: schamorro
 * Date: 16/09/14.
 */
@RestController
@RequestMapping("/acc_pref")
public class AccPreferenteResourceRESTimpl extends CommonResource {

	private static final Logger log = LoggerFactory.getLogger(AccPreferenteResourceRESTimpl.class);
	
	
	@Autowired
	private AccionPreferenteService acc_prefservice;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "APPLICATION/JSON")
	public Accion getAccPrefById(@PathVariable("id") String id) {
		
		log.info("ServicioRest");
		Accion acc_pref= acc_prefservice.getAccPrefById(id);
		log.info("Fin ServicioRest");
		return acc_pref;
	};
	
	public Accion getAccReactById(@PathVariable("id") String id) {
		
		log.info("ServicioRest");
		Accion acc_react= acc_prefservice.getAccReactById(id);
		log.info("Fin ServicioRest");
		return acc_react;
	};
}
