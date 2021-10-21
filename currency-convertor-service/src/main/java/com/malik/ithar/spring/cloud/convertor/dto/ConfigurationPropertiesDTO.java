package com.malik.ithar.spring.cloud.convertor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfigurationPropertiesDTO {

    private int lockoutMaxAttempts;
    private int lockoutDuration;
    private String message;
    private String status;

}
