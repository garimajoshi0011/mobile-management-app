package com.mobile.management.entities;

import javax.persistence.*;

@Entity
@Table(name = "mobile")
public class Mobile {

	@Id
	private Integer id;

	@Column(name = "product_name")
	private String productName;
	private Double price;
	private String description;
	private String brand;
	private String colour;
	@Column(name = "model_no")
	private String modelNo;
	@Column(name = "sim_type")
	private String simType;

	Mobile() {
	}

	public Mobile(Integer id, String productName, Double price, String description, String brand, String colour,
			String modelNo, String simType) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.brand = brand;
		this.colour = colour;
		this.modelNo = modelNo;
		this.simType = simType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getSimType() {
		return simType;
	}

	public void setSimType(String simType) {
		this.simType = simType;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", productName=" + productName + ", price=" + price + ", description=" + description
				+ ", brand=" + brand + ", colour=" + colour + ", modelNo=" + modelNo + ", simType=" + simType + "]";
	}

}
