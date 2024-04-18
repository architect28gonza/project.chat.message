package com.application.login.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.login.domain.dto.RequestTokenUser;
import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.TokenServices;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class LoginController {
    
    private final TokenServices tokenServices;

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseJwtUser> getTokenUser(@RequestBody RequestTokenUser requestUser) {
        return tokenServices.generetaTokenUser(requestUser.getUsername(), requestUser.getPassword());        
    }

    @PostMapping(value = "token", produces = MediaType.TEXT_PLAIN_VALUE)
    public String validTokenApi() {
        return "OK";
    }
    
}