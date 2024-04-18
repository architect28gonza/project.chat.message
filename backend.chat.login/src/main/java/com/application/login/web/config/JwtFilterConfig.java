package com.application.login.web.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.application.login.domain.dto.ResponseErrorAuth;
import com.application.login.domain.service.impl.JwtImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilterConfig extends OncePerRequestFilter {

    private final JwtImpl serviceJsonWebToken;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String headerAutenticacion = request.getHeader("Authorization");

        if ((headerAutenticacion == null) || !headerAutenticacion.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jsonWebToken = headerAutenticacion.substring(7);
        final boolean isTokenExpirado = this.serviceJsonWebToken.isExpiredToken(jsonWebToken);
        if (!isTokenExpirado) {
            final String nombreUsuario = serviceJsonWebToken.extractJwtUserName(jsonWebToken);
            if ((nombreUsuario != null) && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(nombreUsuario);
                if (this.serviceJsonWebToken.isTokenValid(jsonWebToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else
                    setErrorAuth(response);
            }
        } else {
            setErrorAuth(response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private void setErrorAuth(HttpServletResponse response) throws IOException {
        final int HTTP_DENEGADO = 403;
        final String errorMessage = "El token de autenticación ha expirado o no es valido";
        log.warn(errorMessage);
        ResponseErrorAuth valueResponseErrorAuth = new ResponseErrorAuth();
        valueResponseErrorAuth.setStatus(HTTP_DENEGADO);
        valueResponseErrorAuth.setMessage(errorMessage);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        String jsonError = new ObjectMapper().writeValueAsString(valueResponseErrorAuth);
        response.getWriter().write(jsonError);
    }

}
