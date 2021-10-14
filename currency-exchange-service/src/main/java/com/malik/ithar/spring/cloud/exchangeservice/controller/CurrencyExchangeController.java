package com.malik.ithar.spring.cloud.exchangeservice.controller;

import com.malik.ithar.spring.cloud.exchangeservice.domain.ExchangeRate;
import com.malik.ithar.spring.cloud.exchangeservice.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/currency-exchange-service/v1")
public class CurrencyExchangeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final Environment environment;
    private final CurrencyExchangeRepository exchangeRepository;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.exchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("/exchange/{from}/{to}")
    public ExchangeRate exchangeValue(@PathVariable String from, @PathVariable String to) {

        from = from.toUpperCase();
        to = to.toUpperCase();

        Optional<ExchangeRate> exchangeOpt = exchangeRepository.findByFromAndTo(from, to);

        if (exchangeOpt.isEmpty()) {
            LOGGER.warn("Exchanging from:{} to:{} failed.", from, to);
            return new ExchangeRate(1L, from, to, BigDecimal.valueOf(0), "");
        }

        ExchangeRate exchange_rate = exchangeOpt.get();
        exchange_rate.setEnvironment(environment.getProperty("local.server.port"));

        LOGGER.info("Exchanging from:{} to:{} = {}", from, to, exchange_rate.getConversion());

        return exchange_rate;
    }

}
