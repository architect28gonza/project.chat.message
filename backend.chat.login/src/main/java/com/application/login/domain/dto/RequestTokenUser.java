package com.application.login.domain.dto;

import lombok.Getter;
import lombok.Setter;

public class RequestTokenUser {
    
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;
}
