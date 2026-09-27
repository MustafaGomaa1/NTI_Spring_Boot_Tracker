package com.example.tracker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "task")
public record ProbObj(@DefaultValue("mustafa") String name, @DefaultValue("24") int age) {

}
