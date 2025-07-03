package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
	
	
	private String responseCode;
	private String responseMessage;
	
	private ProductRequest request;
	
	private Integer id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductRequest getRequest() {
		return request;
	}
	public void setRequest(ProductRequest request) {
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
