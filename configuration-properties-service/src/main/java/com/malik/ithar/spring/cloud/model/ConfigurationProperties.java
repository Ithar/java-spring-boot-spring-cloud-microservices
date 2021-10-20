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

    @Value("${limit.service.min:0}")
    private String min;

    @Value("${limit.service.max:0}")
    private String max;

}
