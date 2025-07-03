package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {

	private String responseCode;

	private String responseMessage;
	
	private UserRequest request;
	
	private Integer id;
	

	public UserRequest getRequest() {
		return request;
	}

	public void setRequest(UserRequest request2) {
		this.request = request2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
