package com.malik.ithar.spring.cloud.controller;

import com.malik.ithar.spring.cloud.model.PropertiesResponse;
import com.malik.ithar.spring.cloud.model.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limiting-service/v1")
public class ConfigurationController {

    private final ConfigurationProperties configurationProperties;

    public ConfigurationController(ConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @GetMapping("/limit")
    public PropertiesResponse getLimit() {

        return new PropertiesResponse(
                configurationProperties.getLockoutMax(),
                configurationProperties.getLockoutDuration(),
                configurationProperties.getMessage());
    }


}
