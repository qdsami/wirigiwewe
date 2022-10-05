package com.example.project.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

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

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
