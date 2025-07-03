package org.dnyanyog.dto;

public class UpdateProductResponse {

	private String responseCode;

	private String responseMessage;
	
	private UpdateProductRequest request;
	


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

	public UpdateProductRequest getRequest() {
		return request;
	}

	public void setRequest(UpdateProductRequest request2) {
		this.request = request2;
	}

	
	
	
	
	
}
