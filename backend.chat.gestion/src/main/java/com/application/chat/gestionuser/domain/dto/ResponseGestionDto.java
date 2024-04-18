package com.application.chat.gestionuser.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ResponseGestionDto {

    private String message;
    private String status;

}
