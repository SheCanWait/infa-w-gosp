package com.baeldung.application.entities;

import javax.persistence.*;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private final String name;
    @Column
    private final String email;
    
    public User() {
        this.name = "";
        this.email = "";
    }
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + '}';
    }
}
