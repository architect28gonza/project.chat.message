package com.application.login.domain.service;

import java.util.Map;

public interface JwtServices {

    String setGenerateToken(Map<String, Object> claims, String username);

    boolean isExpiredToken(String token);
}
