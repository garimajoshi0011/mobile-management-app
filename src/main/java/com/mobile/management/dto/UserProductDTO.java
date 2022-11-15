package com.mobile.management.dto;

import com.mobile.management.entities.Mobile;
import com.mobile.management.entities.User;

public class UserProductDTO {

	private String name;
	private String about;
	private double price;
	private int age;
	private Mobile product;
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Mobile getProduct() {
		return product;
	}

	public void setProduct(Mobile product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
