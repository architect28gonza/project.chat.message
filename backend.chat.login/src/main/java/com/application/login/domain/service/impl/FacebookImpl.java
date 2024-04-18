package com.application.login.domain.service.impl;

import static com.application.login.util.enun.TypeAuthentication.FACEBOOK;
import static org.springframework.http.HttpMethod.GET;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.login.domain.dto.ParamResponseDto;
import com.application.login.domain.dto.ResponseJwtUser;
import com.application.login.domain.service.FacebookServices;
import com.application.login.util.MessageResponseToken;
import com.application.login.util.keyJsonCredentialsIUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacebookImpl implements FacebookServices {

    @Override
    public ResponseEntity<ResponseJwtUser> getTokenFacebook() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(getUrlFacebook(), GET, entity, String.class);
            JSONObject jsonObject = new JSONObject(response.getBody());
            String accessToken = jsonObject.getString("access_token");
            return ResponseEntity.ok(MessageResponseToken.getResponseJwtUser(getParamResponseDtoGoogle(accessToken, FACEBOOK.toString())));
        } catch (Exception e) {
            System.out.println("ERROR : ".concat(e.getMessage()));
        }
        return ResponseEntity.notFound().build();
    }

    private String getUrlFacebook() {
        final String urlFacebook = keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsFacebook.json",
                "url_facebook", false);
        final String clientId = keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsFacebook.json",
                "client_id",
                false);
        final String clientSecret = keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsFacebook.json",
                "client_secret", false);
        final String grantType = keyJsonCredentialsIUtil.getCampoJsonCredentials("credentialsFacebook.json",
                "grant_type", false);
        StringBuilder url = new StringBuilder("");
        url.append(urlFacebook).append("?".concat("client_id=").concat(clientId));
        url.append("&".concat("client_secret=").concat(clientSecret));
        url.append("&".concat("grant_type=").concat(grantType));
        return url.toString();
    }

    private ParamResponseDto getParamResponseDtoGoogle(String token, String provider) {
        return ParamResponseDto.builder()
                .accessToken(token)
                .provider(provider)
                .username("user_facebook")
                .nickname("nick_username_facebook")
                .build();
    }
}
