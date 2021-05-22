package com.baeldung.application.entities;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Entity
public class LoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column(unique = true)
    private final String username;
    @Column
    private final String password;

    public LoginData() {
        this.username = StringUtils.EMPTY;
        this.password = StringUtils.EMPTY;
    }

    public LoginData(String login, String password) {
        this.username = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + '}';
    }
}
