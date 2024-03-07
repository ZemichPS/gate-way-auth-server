package com.gateway.authclient.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder
                .routes()
                .route("secret_resource", route -> route.path("/secret")
                       .filters(filter -> filter.tokenRelay())
                        .uri("http://localhost:8090")
                )
                .build();
    }

}
