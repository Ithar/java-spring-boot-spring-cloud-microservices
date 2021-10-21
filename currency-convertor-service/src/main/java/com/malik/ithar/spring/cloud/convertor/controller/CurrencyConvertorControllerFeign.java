package com.malik.ithar.spring.cloud.convertor.controller;

import com.malik.ithar.spring.cloud.convertor.domain.CurrencyConversionResponse;
import com.malik.ithar.spring.cloud.convertor.dto.ConfigurationPropertiesDTO;
import com.malik.ithar.spring.cloud.convertor.dto.ExchangeRateDTO;
import com.malik.ithar.spring.cloud.convertor.proxy.ConfigurationPropertiesProxy;
import com.malik.ithar.spring.cloud.convertor.proxy.CurrencyExchangeProxy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("currency-convertor/v2")
public class CurrencyConvertorControllerFeign {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConvertorControllerFeign.class);

    private final CurrencyExchangeProxy currencyExchangeProxy;
    private final ConfigurationPropertiesProxy configurationPropertiesProxy;

    public CurrencyConvertorControllerFeign(CurrencyExchangeProxy currencyExchangeProxy, ConfigurationPropertiesProxy configurationPropertiesProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
        this.configurationPropertiesProxy = configurationPropertiesProxy;
    }

    @GetMapping("/convert/{from}/{to}")
    public CurrencyConversionResponse convertViaFeign(@PathVariable String from, @PathVariable String to, @RequestParam(required = false) Integer quantity) {

        if (quantity == null) {
            quantity = 1;
        }

        LOGGER.info("Converting: from to quantity [{} - {}] q={}", from, to, quantity);

        ExchangeRateDTO exchangeRateDTO = currencyExchangeProxy.getExchangeValue(from, to);

        ConfigurationPropertiesDTO configurationPropertiesDTO = configurationPropertiesProxy.getProperties();

        return CurrencyConversionResponse
                .builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .rate(exchangeRateDTO.getRate())
                .total(BigDecimal.valueOf(quantity).multiply(exchangeRateDTO.getRate()))
                .exchangeServer("Exchange Server ("+ exchangeRateDTO.getEnvironment() +")")
                .message(configurationPropertiesDTO.getMessage())
                .build();
    }

}
