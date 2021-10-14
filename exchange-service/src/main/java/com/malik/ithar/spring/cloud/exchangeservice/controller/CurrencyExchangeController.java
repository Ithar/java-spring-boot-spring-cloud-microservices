package com.malik.ithar.spring.cloud.exchangeservice.controller;

import com.malik.ithar.spring.cloud.exchangeservice.domain.Exchange;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/exchange-service/v1")
public class CurrencyExchangeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/exchange/{from}/{to}")
    public Exchange exchangeValue(@PathVariable String from, @PathVariable String to) {

        // TODO [IM 21-10-13] - Set port
        Exchange exchange = new Exchange(1L, from, to, BigDecimal.valueOf(60), environment.getProperty("local.server.port"));

        LOGGER.info("Exchanging from:{} to:{} = {}", from, to, exchange.getConversion());

        return exchange;
    }

}
