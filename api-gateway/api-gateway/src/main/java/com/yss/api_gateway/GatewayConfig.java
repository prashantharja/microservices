package com.yss.api_gateway; // Make sure this matches your actual package name

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // If a request comes in with the path /orders/**
                // Route it dynamically via Eureka to ORDER-FULFILLMENT-SERVICE
                .route("order-service-route", r -> r.path("/orders/**")
                        .uri("lb://order-fulfillment-service"))
                .build();
    }
}