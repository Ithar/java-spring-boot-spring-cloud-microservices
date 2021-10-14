package com.malik.ithar.spring.cloud.convertor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ExchangeRateDTO {

    private BigDecimal rate;

}
