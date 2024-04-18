package com.application.chat.gestionuser.util.response;

import com.application.chat.gestionuser.domain.dto.ResponseGestionDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseUtil {
    public static ResponseGestionDto responseGestion(String message, String status) {
        return ResponseGestionDto.builder()
                .message(message)
                .status(status).build();
    }
}
