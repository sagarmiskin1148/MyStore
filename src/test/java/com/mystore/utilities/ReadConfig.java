package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    String path = System.getProperty("user.dir") + "/Configuration/config.properties"; // ✅ Use relative path

    public ReadConfig() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + path, e);
        }
    }

    public String getBaseUrl() {
        String value = properties.getProperty("baseurl");
        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Error: 'baseurl' is missing in config.properties");
        }
        return value;
    }

    public String getBrowser() {
        String value = properties.getProperty("browser");
        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Error: 'browser' is missing in config.properties");
        }
        return value;
    }

    public String getEmail() {
        String email = properties.getProperty("email");
        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Error: 'email' is missing in config.properties");
        }
        return email;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Error: 'password' is missing in config.properties");
        }
        return password;
    }
}
