package com.malik.ithar.spring.cloud.exchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversion;


}
