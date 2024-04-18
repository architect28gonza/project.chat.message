package com.application.chat.gestionuser.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserGestionDto {
 
    private String username;
    private String password;
    private String nickname;
    private String photo;

}
