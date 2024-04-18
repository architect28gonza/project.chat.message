package com.application.login.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParamResponseDto {
    private String accessToken;
    private String provider;
    private String username;
    private String nickname;
    private Long id;
}
