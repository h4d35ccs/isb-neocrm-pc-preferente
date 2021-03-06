package com.isb.neocrm.pc.preferente.pres.rs.api.responsecode;
/**
 * Enum that define the error codes in the service layer
 * All the errors will start from 200 to 299
 * @author ottoabreu
 *
 */
public enum ServiceLayerErrorCode implements ErrorCode{

	GENERAL_ERROR(200,"An error in the service layer prevented to continue with the operation "),
	INVALID_PARAMS_ERROR(201,"The params given do not have the apropiated format ");
	
	private Integer code;
	private String description;
	
	
	private ServiceLayerErrorCode(int code, String description){
		this.code = code;
		this.description = description;
	}

	@Override
	public int getErrorCode() {
		// TODO Auto-generated method stub
		return this.code;
	}

	@Override
	public String getErrorDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	
	@Override
	public boolean equals(ErrorCode other) {

		if (other.getErrorDescription().equals(this.description)
				&& other.getErrorCode() == this.code) {
			return true;
		} else {
			return false;
		}
	}
}
