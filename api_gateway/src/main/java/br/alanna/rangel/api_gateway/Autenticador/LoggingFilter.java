package br.alanna.rangel.api_gateway.Autenticador;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public class LoggingFilter implements GlobalFilter, Ordered, GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    @Override
    public ShortcutType shortcutType() {
        return GatewayFilter.super.shortcutType();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return GatewayFilter.super.shortcutFieldOrder();
    }

    @Override
    public String shortcutFieldPrefix() {
        return GatewayFilter.super.shortcutFieldPrefix();
    }
}
