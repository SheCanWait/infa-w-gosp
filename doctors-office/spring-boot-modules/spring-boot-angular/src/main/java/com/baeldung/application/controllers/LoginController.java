package com.baeldung.application.controllers;

import com.baeldung.application.repositories.LoginRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController extends ApplicationController {

    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/register")
    public boolean getUsers() {
        return false;
    }

    @PostMapping("/login")
    public boolean addUser() {
        return true;
    }
}
