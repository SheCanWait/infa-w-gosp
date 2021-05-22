package com.baeldung.application.controllers;

import com.baeldung.application.entities.LoginData;
import com.baeldung.application.repositories.LoginRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/register")
    @Transactional
    public void register(@RequestBody LoginData loginData) {
        boolean userAlreadyExist = loginRepository.doesUserAlreadyExist(loginData.getUsername());
        if(!userAlreadyExist) {
            loginRepository.register(loginData.getUsername(), loginData.getPassword());
        }
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginData loginData) {
        return loginRepository.login(loginData.getUsername(), loginData.getPassword()) == 1;
    }
}
