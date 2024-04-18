package com.application.chat.gestionuser.web.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilterConfig extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    @Value("${application.chat.url-login}")
    private String URL_LOGIN;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String headerAutenticacion = request.getHeader("Authorization");
        if ((headerAutenticacion == null) || !headerAutenticacion.contains("Bearer ")) {
            filterChain.doFilter(request, response);
            System.out.println("Entrada de condición");
            return;
        }

        final String statusResponse = validToken(headerAutenticacion);
        System.out.println("ESTATUS : " + statusResponse);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(statusResponse);
        if (userDetails != null) {
            System.out.println("Entrada a los valores");
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        filterChain.doFilter(request, response);
    }

    private String validToken(String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Authorization", token.replaceAll("[\"']", ""));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    URL_LOGIN, HttpMethod.POST, entity,
                    String.class);
            System.out.println("RESULTADO::: " + response.getStatusCode().toString());
            return response.getStatusCode().toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
