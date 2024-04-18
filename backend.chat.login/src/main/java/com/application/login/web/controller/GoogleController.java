package com.application.login.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.login.domain.dto.RequestCodeGoogle;
import com.application.login.domain.dto.ResponseAuthorizationGoogle;
import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.GoogleServices;

import lombok.AllArgsConstructor;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth/")
@AllArgsConstructor
public class GoogleController {

    private final GoogleServices googleServices;

    @GetMapping(value = "google", produces = "application/json")
    public ResponseEntity<ResponseAuthorizationGoogle> getRedirectGoogle() {
        return googleServices.connectToGoogle();
    }

    @PostMapping(value = "google", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseJwtUser> getTokenGoogle(@RequestBody RequestCodeGoogle request) throws IOException {
        return googleServices.generateTokenGoogle(request.getCode());
    }

}
