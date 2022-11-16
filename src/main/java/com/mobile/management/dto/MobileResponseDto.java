package com.mobile.management.dto;

public class MobileResponseDto {

	private String name;
	private String productName;
	
	public MobileResponseDto() {
	}

	public MobileResponseDto(String name, String productName) {
		this.name = name;
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "MobileResponseDto [name=" + name + ", productName=" + productName + "]";
	}

}
