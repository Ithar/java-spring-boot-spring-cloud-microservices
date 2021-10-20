package com.malik.ithar.spring.cloud.gateway.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GatewayLogger implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayLogger.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        LOGGER.info("Requested path -> {}: {}", request.getMethodValue(), request.getPath());
        return chain.filter(exchange);
    }
}
