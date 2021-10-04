package com.malik.ithar.spring.cloud.limitservice.controoler;

import com.malik.ithar.spring.cloud.limitservice.business.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @GetMapping
    public Limit getLimit() {
        return new Limit(1, 500);
    }

}
