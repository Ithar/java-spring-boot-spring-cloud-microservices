package com.malik.ithar.spring.cloud.convertor.controller;

import com.malik.ithar.spring.cloud.convertor.domain.CurrencyConversionResponse;
import com.malik.ithar.spring.cloud.convertor.dto.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("currency-convertor/v1")
public class CurrencyConvertorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConvertorController.class);

    @GetMapping("/convert/{from}/{to}")
    public CurrencyConversionResponse convert(@PathVariable String from, @PathVariable String to, @RequestParam(required = false) Integer quantity) throws Exception {

        if (quantity == null) {
            quantity = 1;
        }

        LOGGER.info("Converting: from to quantity [{} - {}] q={}", from, to, quantity);

        String url = getExchangeRateUrl(from, to);

        ResponseEntity<ExchangeRateDTO> responseEntity =  new RestTemplate().getForEntity(url, ExchangeRateDTO.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            CurrencyConversionResponse conversion = buildResponse(from, to, quantity, Objects.requireNonNull(responseEntity.getBody()));
            LOGGER.info("Converting: from to quantity [{} - {}] q={} t={}]", from, to, quantity, conversion.getTotal());
            return conversion;
        }

        throw new Exception("Unable to convert at present");
    }

    private CurrencyConversionResponse buildResponse(String from, String to, Integer quantity, ExchangeRateDTO body) {

        BigDecimal rate = body.getRate();

        return CurrencyConversionResponse
                .builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .rate(rate)
                .total(BigDecimal.valueOf(quantity).multiply(rate))
                .build();
    }

    private String getExchangeRateUrl(String from, String to) {
        // TODO [IM 21-10-19] - Get the name from the limiting service
        return String.format("http://localhost:8000/currency-exchange-application/v1/exchange/%s/%s", from, to);
    }

}
