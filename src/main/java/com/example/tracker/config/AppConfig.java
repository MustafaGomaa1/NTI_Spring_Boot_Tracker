package com.example.tracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Profile("dev")
@Slf4j
// @EnableConfigurationProperties(ProbObj.class) // Tells Spring to manage
// ProbObj
public class AppConfig {
    private final ProbObj probObj;

    // Spring injects ProbObj here once properties are bound
    public AppConfig(ProbObj probObj) {
        this.probObj = probObj;
    }

    @PostConstruct
    public void init() {
        log.debug("Profile Dev Activated");
        log.info(probObj.name());
        log.warn(String.valueOf(probObj.age()));
    }
}