package com.malik.ithar.spring.cloud.convertor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-convertor-service/v1")
public class CurrencyConvertorController {

    @GetMapping("/convert")
    public String convert() {

        return "Hello we are about convert";
    }

}
