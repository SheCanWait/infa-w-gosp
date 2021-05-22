package com.baeldung.application.entities;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String login;
    private final String password;

    public LoginData() {
        this.login = StringUtils.EMPTY;
        this.password = StringUtils.EMPTY;
    }

    public LoginData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.getId() + ", name=" + this.getLogin() + ", email=" + this.getPassword() + '}';
    }
}
