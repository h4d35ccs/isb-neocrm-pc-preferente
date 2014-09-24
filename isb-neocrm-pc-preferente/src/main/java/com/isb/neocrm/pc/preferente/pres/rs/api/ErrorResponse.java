package com.isb.neocrm.pc.preferente.pres.rs.api;

/**
 * Author: schamorro
 * Date: 02/09/14.
 */
public class ErrorResponse implements Response {
    
	
	
	private static final long serialVersionUID = 1L;
	
	
	private int errorCode;
    private String consumerMessage;
    private String applicationMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getConsumerMessage() {
        return consumerMessage;
    }

    public void setConsumerMessage(String consumerMessage) {
        this.consumerMessage = consumerMessage;
    }

    public String getApplicationMessage() {
        return applicationMessage;
    }

    public void setApplicationMessage(String applicationMessage) {
        this.applicationMessage = applicationMessage;
    }

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", consumerMessage="
				+ consumerMessage + ", applicationMessage="
				+ applicationMessage + "]";
	}
    
    
}
