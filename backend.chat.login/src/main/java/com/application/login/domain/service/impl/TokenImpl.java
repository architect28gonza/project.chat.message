package com.application.login.domain.service.impl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.login.domain.dto.ParamResponseDto;
import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.JwtServices;
import com.application.login.domain.service.TokenServices;
import com.application.login.persistence.entity.UserEntity;
import com.application.login.util.MessageResponseToken;
import static com.application.login.util.enun.TypeAuthentication.JWT;

import lombok.AllArgsConstructor;

import com.application.login.domain.repository.UserRepository;

@Service
@AllArgsConstructor
public class TokenImpl implements TokenServices {

    private final UserRepository userRepository;

    private final JwtServices jwtServices;

    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<ResponseJwtUser> generetaTokenUser(String username, String password) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        UserEntity user = optionalUser.get();
        if (checkPassword(password, user.getPassword())) {
            String token = jwtServices.setGenerateToken(new HashMap<>(), username);
            ResponseJwtUser responseJwtUser = MessageResponseToken.getResponseJwtUser(
                getParamResponseDtoToken(token, JWT.toString(), user));
            return ResponseEntity.ok(responseJwtUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

     private ParamResponseDto getParamResponseDtoToken(String token, String provider, UserEntity user) {
        return ParamResponseDto.builder()
                .accessToken(token)
                .provider(provider)
                .username(user.getUsername())
                .nickname(user.getNickname())
                .id(user.getId())
                .build();
    }
}
