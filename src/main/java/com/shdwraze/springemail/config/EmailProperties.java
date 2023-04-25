package com.shdwraze.springemail.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@AllArgsConstructor
public class EmailProperties {

    private Environment env;

    public String getEmail() {
        return env.getProperty("MAIL_USER");
    }
}
