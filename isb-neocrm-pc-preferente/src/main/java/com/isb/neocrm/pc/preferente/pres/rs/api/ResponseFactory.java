package com.isb.neocrm.pc.preferente.pres.rs.api;

import org.springframework.stereotype.Component;

import com.isb.neocrm.pc.preferente.logic.domain.Accion;
import com.isb.neocrm.pc.preferente.pres.rs.api.responsecode.ErrorCode;
import com.isb.neocrm.pc.preferente.pres.rs.api.responsecode.ResponseCodeFactory;

/**
 * Class that instanciate the differents types of responses
 * 
 * @author ottoabreu
 * 
 */
@Component
public class ResponseFactory {
	

	public Response instanciateAccionResponse(Accion accion) {
    	AccionResponse response = new AccionResponse();
		response.addActionObject(accion);
		return response;
	}

	public Response instanciateErrorResponse(Throwable error) {
		ErrorResponse response = new ErrorResponse();
		response.setApplicationMessage(error.getLocalizedMessage());
		ErrorCode errorCode = ResponseCodeFactory.generateErrorCode(error);
		response.setErrorCode(errorCode.getErrorCode());
		response.setConsumerMessage(errorCode.getErrorDescription());
		return response;
	}

	
}
