package com.malik.ithar.spring.cloud.convertor.proxy;

import com.malik.ithar.spring.cloud.convertor.dto.ExchangeRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Let the Feign client load balance which exchange server (8000 or 8001) to choose from the Eureka naming server.
@FeignClient(name="currency-exchange-application")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/v1/exchange/{from}/{to}")
    ExchangeRateDTO getExchangeValue(@PathVariable String from, @PathVariable String to);
}
