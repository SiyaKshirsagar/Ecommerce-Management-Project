package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductRequest {
  
	private String name;
	private String price;
	private String quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	

	
}
