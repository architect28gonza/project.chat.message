package com.application.login.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseAuthorizationGoogle {
    private String message;
    private String authorization;
    private int status;
}
