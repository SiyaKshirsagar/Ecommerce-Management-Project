package org.dnyanyog.dto;

public class UpdateUserResponse {
	private String responseCode;

	private String responseMessage;
	
	private UpdateUserRequest request;
	


	public UpdateUserRequest getRequest() {
		return request;
	}

	public void setRequest(UpdateUserRequest request) {
		this.request = request;
	}

	

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
