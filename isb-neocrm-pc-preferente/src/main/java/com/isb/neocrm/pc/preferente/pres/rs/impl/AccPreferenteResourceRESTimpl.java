package com.isb.neocrm.pc.preferente.pres.rs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.pres.rs.AccionPreferenteResource;
import com.isb.neocrm.pc.preferente.pres.rs.api.Response;
import com.isb.neocrm.pc.preferente.pres.rs.api.ResponseFactory;

/**
 * Implementación del servicio REST
 * Author: Otto Abreu
 * Date: 23/09/14.
 */

public class AccPreferenteResourceRESTimpl {

	private static final Logger log = LoggerFactory.getLogger(AccPreferenteResourceRESTimpl.class);
	
	
	@Autowired
	private AccionPreferenteResource accionPreferente;
	
	@Autowired
	private ResponseFactory responseFactory;
	
	@GET
	@Path("/acc_pref/{personType}/{personCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccPrefById(@PathParam("personType") String personType,@PathParam("personCode") String personCode) {
		
		log.info("Preferente Rest service Invoked");
		Response response = this.getActionPrefResponse(personType,personCode);
		log.info("Preferente Rest service Ends: "+response);
		return response;
	}
	
	private Response getActionPrefResponse(String personType,String personCode){
		Response response = null;
		
		try {
			
			Accion accpref= accionPreferente.getAccPrefById(personType,personCode);
			response = this.generateResponseFromAction(accpref);
		
		} catch (Exception e) {
			
			response= this.handleError(e);
		}
		
		return response;
	}
	
	
	private Response generateResponseFromAction(Accion action){
		return this.responseFactory.instanciateAccionResponse(action);
	}
	
	private Response handleError(Exception e){
		return this.responseFactory.instanciateErrorResponse(e);
	}
}
