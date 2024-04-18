package com.application.login.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorAuth {
    private String message;
    private int status;
}
