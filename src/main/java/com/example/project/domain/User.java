package com.example.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;
    private String email;
    private String password;
    private String name;
    private int age;
    private String city;
    private String description;
    private String link;
    private boolean wantToBeAdded;
    private boolean wannaAdd;

    public User() {
    }

    public User(String login, String email, String password, String name, int age, String city, String description, String link, boolean wantToBeAdded, boolean wannaAdd) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.city = city;
        this.description = description;
        this.link = link;
        this.wantToBeAdded = wantToBeAdded;
        this.wannaAdd = wannaAdd;
    }

    public User(String login, String email, String password, String name, int age, String city, String description, String link) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.city = city;
        this.description = description;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isWantToBeAdded() {
        return wantToBeAdded;
    }

    public void setWantToBeAdded(boolean wantToBeAdded) {
        this.wantToBeAdded = wantToBeAdded;
    }

    public boolean isWannaAdd() {
        return wannaAdd;
    }

    public void setWannaAdd(boolean wannaAdd) {
        this.wannaAdd = wannaAdd;
    }
}
