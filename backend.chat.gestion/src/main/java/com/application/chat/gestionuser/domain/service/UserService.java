package com.application.chat.gestionuser.domain.service;

import org.springframework.http.ResponseEntity;
import com.application.chat.gestionuser.domain.dto.ResponseGestionDto;
import com.application.chat.gestionuser.domain.dto.UserGestionDto;

public interface UserService {

    ResponseEntity<ResponseGestionDto> addUser(UserGestionDto userDto);
}
