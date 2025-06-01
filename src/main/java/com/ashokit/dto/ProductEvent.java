package com.ashokit.dto;

import com.ashokit.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductEvent {

    private String eventType;
    private Product product;
    
    
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductEvent() {}
	
	public ProductEvent(String eventType, Product product) {
		super();
		this.eventType = eventType;
		this.product = product;
	}
	@Override
	public String toString() {
		return "ProductEvent [eventType=" + eventType + ", product=" + product + "]";
	}
    
    
    
}
