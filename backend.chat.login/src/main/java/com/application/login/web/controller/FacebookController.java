package com.application.login.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.FacebookServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class FacebookController {

    private final FacebookServices facebookServices;

    @GetMapping("facebook")
    public ResponseEntity<ResponseJwtUser> facebookAuth() {
        return facebookServices.getTokenFacebook();
    }
}
