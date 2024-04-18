package com.application.login.domain.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.application.login.domain.service.JwtServices;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtImpl implements JwtServices {

    private final static String SECRET_TOKEN = "9aaf7b6e2c692f9e3a36c9d67ec7c609d42c50b93cc14b79f8ff83536c46f31c";

    private static final int TIEMPO_TOKEN = 12 * 60 * 60 * 1000;

    @Override
    public String setGenerateToken(Map<String, Object> claims, String username) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TIEMPO_TOKEN))
                .signWith(this.getFirmaClave(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isExpiredToken(String token) {
        try {
            return this.extraerExpiracionToken(token).before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String usuario = this.extractJwtUserName(token);
        return (usuario.equals(userDetails.getUsername())) && !this.isExpiredToken(token);
    }

    public String extractJwtUserName(String token) {
        return this.extraerClaims(token, Claims::getSubject);
    }

    private Key getFirmaClave() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_TOKEN);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims extraerAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getFirmaClave())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extraerClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extraerAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date extraerExpiracionToken(String token) {
        return this.extraerClaims(token, Claims::getExpiration);
    }
}
