package com.application.login.web.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

@Configuration
public class GoogleInit {

    private List<String> getSingletonList() {
        return Collections.singletonList("https://www.googleapis.com/auth/drive.file");
    }

    private GoogleClientSecrets getGoogleClientSecrets() throws IOException {
        String currentDirectory = System.getProperty("user.dir").concat("/".concat("credentialsGoogle.json"));
        System.out.println("RUTA:::");
        System.out.println(currentDirectory);
        InputStream resourceStream = new FileInputStream(currentDirectory);
        return GoogleClientSecrets.load(GsonFactory.getDefaultInstance(), new InputStreamReader(resourceStream));
    }

    @Bean
    public GoogleAuthorizationCodeFlow getGoogleAuthorizationCodeFlow() throws GeneralSecurityException, IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                getGoogleClientSecrets(),
                getSingletonList())
                .setAccessType("offline")
                .build();
    }
}
