package com.malik.ithar.spring.cloud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
public class ConfigurationProperties {

    @Value("${lockout.max.attempt.number:0}")
    private String lockoutMax;

    @Value("${lockout.duration.time.minutes:0}")
    private Integer lockoutDuration;

    @Value("${lockout.response.msg: This message is coming from 'DEFAULT' project java class}")
    private String message;

}
