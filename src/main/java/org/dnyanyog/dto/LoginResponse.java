package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
	
	
    private String responseCode;
    private String responseMessage;
    
    
    
    
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
