package com.malik.ithar.spring.cloud.convertor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class CurrencyConversionResponse {

    private String from;
    private String to;
    private int quantity;
    private BigDecimal rate;
    private BigDecimal total;
    private String exchangeServer;

}
