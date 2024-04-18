package com.application.login.domain.service;

import org.springframework.http.ResponseEntity;

import com.application.login.domain.dto.ResponseJwtUser;

public interface TokenServices {

    ResponseEntity<ResponseJwtUser> generetaTokenUser(String username, String password);

}
