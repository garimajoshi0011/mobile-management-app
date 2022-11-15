package com.mobile.management.entities;

import javax.persistence.*;

@Entity
@Table(name= "user_products")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id" , referencedColumnName="id", nullable= true)
    private User userId;

    @ManyToOne
    @JoinColumn(name="product_id" , referencedColumnName="id", nullable= true)
    private Mobile productId;
    
    private String name;
    private String about;
    private Double price;

    //private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Mobile getProductId() {
        return productId;
    }

    public void setProductId(Mobile productId) {
        this.productId = productId;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /*public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }*/
}
