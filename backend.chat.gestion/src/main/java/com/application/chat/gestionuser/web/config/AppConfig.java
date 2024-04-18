package com.application.chat.gestionuser.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.application.chat.gestionuser.domain.service.impl.UserDetailsServiceImp;

@Configuration
public class AppConfig  {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }
}
