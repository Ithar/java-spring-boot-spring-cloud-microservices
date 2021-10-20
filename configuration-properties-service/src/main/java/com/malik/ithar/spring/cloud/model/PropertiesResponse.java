package com.malik.ithar.spring.cloud.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertiesResponse {

    private int min;
    private int max;

    public PropertiesResponse(String min, String max) {
       this.min = Integer.parseInt(min);
       this.max = Integer.parseInt(max);
    }
}
