package com.erdogan.can.utku.movie.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/movie/**")
                        .uri("lb://MOVIE-SERVICE"))
                .route(p -> p.path("/user/**")
                        .uri("lb://USER-SERVICE"))
                .build();
    }
}
