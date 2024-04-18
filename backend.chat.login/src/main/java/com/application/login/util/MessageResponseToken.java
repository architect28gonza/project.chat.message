package com.application.login.util;

import com.application.login.domain.dto.ParamResponseDto;
import com.application.login.domain.dto.ResponseJwtUser;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageResponseToken {

    public static ResponseJwtUser getResponseJwtUser(ParamResponseDto paramResponseDto) {
        return ResponseJwtUser.builder()
                .id(paramResponseDto.getId())
                .message("Se ha generado el token con exito")
                .accessToken(paramResponseDto.getAccessToken())
                .username(paramResponseDto.getUsername())
                .nickname(paramResponseDto.getNickname())
                .status(200)
                .provider(paramResponseDto.getProvider())
                .build();
    }
}
