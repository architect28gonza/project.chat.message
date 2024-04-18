package com.application.login.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class keyJsonCredentialsIUtil {

    public static String getCampoJsonCredentials(String json, String key, boolean isArray) {
        String currentDirectory = System.getProperty("user.dir").concat("/".concat(json));
        try {
            String content = new String(Files.readAllBytes(Paths.get(currentDirectory)));
            JSONObject obj = new JSONObject(content);
            JSONObject web = obj.getJSONObject(key);
            return isArray ? web.getJSONArray(key).getString(0) : web.getString(key).toString();
        } catch (Exception e) {
            
        }
        return "";
    }

}
