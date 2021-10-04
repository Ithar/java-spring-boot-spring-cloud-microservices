package com.malik.ithar.spring.cloud.limitservice.business;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Limit {

    private int min;
    private int max;

    public Limit(String min, String max) {
       this.min = Integer.parseInt(min);
       this.max = Integer.parseInt(max);
    }
}
