package com.application.chat.gestionuser.domain.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    /*
     * No es necesario tenerlas en env, Son solo de almacenamiento
     * NO tienen alguna importancia
     */
    private static final String USERNAME = "username43*54.-432";
    private static final String PASSWORD = "Passorwfdg*54.-425";

    @Override
    public UserDetails loadUserByUsername(String statusResponse) throws UsernameNotFoundException {
        return (statusResponse.contains("200")) ? User.withUsername(USERNAME)
                .password(PASSWORD)
                .roles("USER")
                .build() : null;
    }
}
