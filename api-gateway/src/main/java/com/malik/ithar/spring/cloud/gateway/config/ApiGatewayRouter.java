package com.malik.ithar.spring.cloud.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRouter {

    @Value("${currency.convertor.url}")
    private String currencyConvertorUrl;

    @Bean
    public RouteLocator configureRoutes(RouteLocatorBuilder builder) {

        return builder
                .routes()
                .route(p ->
                        p.path("/exchanger-api/**")
                                .filters(f -> f.rewritePath("exchanger-api", "currency-exchange"))
                                .uri("lb://currency-exchange-application")) // uses the naming server to determine the port
                .route(p ->
                        p.path("/convertor-api/**")
                                .filters(f -> f.rewritePath("convertor-api", "currency-convertor"))
                                .uri(currencyConvertorUrl))
                .build();
    }
    /*
    http://localhost:8765/convertor-api/v2/convert/usd/gbp?quantity=2 >>> http://localhost:8100/{currency-convertor-application}/currency-convertor/v2/convert/usd/gbp?quantity=2
    http://localhost:8765/exchanger-api/v1/exchange/eur/usd >>>> load-balance://{currency-exchange-application}/currency-exchange/v1/exchange/eur/usd
    */
}
