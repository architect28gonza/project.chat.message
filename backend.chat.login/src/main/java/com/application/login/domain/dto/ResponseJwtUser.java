package com.application.login.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseJwtUser {
    
    private String message;
    private String accessToken;
    private int status;
    private String username;
    private String nickname;
    private String provider;
    private Long id;

}
