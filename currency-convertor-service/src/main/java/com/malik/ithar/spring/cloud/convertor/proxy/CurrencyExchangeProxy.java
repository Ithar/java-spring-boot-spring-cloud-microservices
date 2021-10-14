package com.malik.ithar.spring.cloud.convertor.proxy;

import com.malik.ithar.spring.cloud.convertor.dto.ExchangeRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange-service/v1/exchange/{from}/{to}")
    ExchangeRateDTO exchangeValue(@PathVariable String from, @PathVariable String to);
}
