package com.rest.apii.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
private String name;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private Double price;
private String about;

    public Product(String name, Integer id, Double price, String about) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.about = about;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
