package com.application.login.domain.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.application.login.domain.dto.ResponseAuthorizationGoogle;
import com.application.login.domain.dto.ResponseJwtUser;

public interface GoogleServices {
    
    ResponseEntity<ResponseAuthorizationGoogle> connectToGoogle();

    ResponseEntity<ResponseJwtUser> generateTokenGoogle(String code) throws IOException;
}
