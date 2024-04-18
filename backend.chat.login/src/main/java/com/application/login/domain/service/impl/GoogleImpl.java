package com.application.login.domain.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.login.domain.dto.ParamResponseDto;
import com.application.login.domain.dto.ResponseAuthorizationGoogle;
import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.GoogleServices;
import com.application.login.util.MessageResponseToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

import static com.application.login.util.enun.TypeAuthentication.GOOGLE;
import com.application.login.util.keyJsonCredentialsIUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoogleImpl implements GoogleServices {

    private final GoogleAuthorizationCodeFlow GoogleAuthorizationCodeFlow;

    @Override
    public ResponseEntity<ResponseAuthorizationGoogle> connectToGoogle() {
        return ResponseEntity.ok(getResponseGoogle());
    }

    @Override
    public ResponseEntity<ResponseJwtUser> generateTokenGoogle(String code) {
        try {
            GoogleTokenResponse credential = GoogleAuthorizationCodeFlow.newTokenRequest(code)
                    .setRedirectUri(
                            keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsGoogle.json", "redirect_uris",
                                    true))
                    .execute();
            return ResponseEntity
                    .ok(MessageResponseToken.getResponseJwtUser(getParamResponseDtoGoogle(credential.getAccessToken(), GOOGLE.toString())));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    private ResponseAuthorizationGoogle getResponseGoogle() {
        return ResponseAuthorizationGoogle.builder()
                .message("Redireccionamiento de Google")
                .authorization(GoogleAuthorizationCodeFlow.newAuthorizationUrl()
                        .setRedirectUri(
                                keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsGoogle.json",
                                        "redirect_uris", true))
                        .build())
                .status(200)
                .build();
    }

    private ParamResponseDto getParamResponseDtoGoogle(String token, String provider) {
        return ParamResponseDto.builder()
                .accessToken(token)
                .provider(provider)
                .username("user_google")
                .nickname("nick_username_google")
                .build();
    }

}