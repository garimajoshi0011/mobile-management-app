package com.rest.api.entities;


import javax.persistence.*;


@Entity
@Table(name="user")
public class User {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;

    private String password;

    public String getName() {
        return name;
    }

    public User(String name, Integer id, Integer age, String password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.password = password;
    }

    public User() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
