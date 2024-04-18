package com.application.chat.gestionuser.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.chat.gestionuser.domain.dto.UserGestionDto;
import com.application.chat.gestionuser.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MapperApp {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntity userDtoToEntity(UserGestionDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        user.setRole("USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return user;
    }
}
