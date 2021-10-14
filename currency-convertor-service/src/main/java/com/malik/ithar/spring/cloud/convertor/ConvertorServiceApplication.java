package com.malik.ithar.spring.cloud.convertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConvertorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvertorServiceApplication.class, args);
    }

}


