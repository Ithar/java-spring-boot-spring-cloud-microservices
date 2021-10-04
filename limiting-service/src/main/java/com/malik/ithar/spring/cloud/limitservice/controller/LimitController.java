package com.malik.ithar.spring.cloud.limitservice.controller;

import com.malik.ithar.spring.cloud.limitservice.business.Limit;
import com.malik.ithar.spring.cloud.limitservice.business.LimitProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    private final LimitProperties limitProperties;

    public LimitController(LimitProperties limitProperties) {
        this.limitProperties = limitProperties;
    }

    @GetMapping
    public Limit getLimit() {
        return new Limit(limitProperties.getMin(), limitProperties.getMax());
    }

}
