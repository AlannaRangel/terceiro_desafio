package br.alanna.rangel.api_gateway.Autenticador;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route_name", r -> r.path("/path_to_service/**")
                        .filters(f -> f.filter(new LoggingFilter()))
                        .uri("lb://service_name"))
                .build();
    }
}
