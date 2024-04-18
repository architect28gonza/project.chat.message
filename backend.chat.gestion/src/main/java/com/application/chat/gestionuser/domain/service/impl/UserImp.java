package com.application.chat.gestionuser.domain.service.impl;

import static org.springframework.http.HttpStatus.ACCEPTED;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.application.chat.gestionuser.domain.dto.ResponseGestionDto;
import com.application.chat.gestionuser.domain.dto.UserGestionDto;
import com.application.chat.gestionuser.domain.service.UserService;
import com.application.chat.gestionuser.persistence.mapper.MapperApp;
import static com.application.chat.gestionuser.util.constants.message.UserConst.*;
import com.application.chat.gestionuser.util.response.ResponseUtil;
import com.application.chat.gestionuser.domain.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserImp implements UserService {

    private final MapperApp mapperApp;

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseGestionDto> addUser(UserGestionDto userDto) {
        this.userRepository.save(this.mapperApp.userDtoToEntity(userDto));
        return new ResponseEntity<>(ResponseUtil.responseGestion(MESSAGE_USER_GESTION, ACCEPTED.toString()), ACCEPTED);
    }
}
