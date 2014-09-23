package com.isb.neocrm.pc.preferente.pres.rs.exceptions;

import com.isb.neocrm.pc.preferente.pres.rs.api.ErrorResponse;

/**
 * Excepción que permite la notificación del mensaje al usuario final.
 * Author: schamorro
 * Date: 16/09/14.
 */
public class BaseWebApplicationException extends RuntimeException {
    private final int status;
    private final String errorMessage;
    private final String errorCode;
    private final String developerMessage;

    public BaseWebApplicationException(int httpStatus, String errorCode, String errorMessage, String developerMessage) {
        this.status = httpStatus;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.developerMessage = developerMessage;
    }


//    @Override
//    public Response getResponse() {
//        return Response.status(status).type(MediaType.APPLICATION_JSON_TYPE).entity(getErrorResponse()).build();
//    }

    public ErrorResponse getErrorResponse() {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(errorCode);
        response.setApplicationMessage(developerMessage);
        response.setConsumerMessage(errorMessage);
        return response;
    }
}
