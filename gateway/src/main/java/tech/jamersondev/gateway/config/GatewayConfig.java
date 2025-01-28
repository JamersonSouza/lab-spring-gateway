package tech.jamersondev.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import tech.jamersondev.gateway.service.FallbackService;


@Configuration
public class GatewayConfig {

    private final FallbackService fallbackService;

    public GatewayConfig(@Lazy FallbackService fallbackService) {
        this.fallbackService = fallbackService;
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("client", route -> route
                        .path("/clients")
                        .filters(f -> f
                                .retry(config -> config
                                        .setRetries(3)
                                        .setStatuses(
                                                HttpStatus.INTERNAL_SERVER_ERROR,
                                                HttpStatus.BAD_REQUEST,
                                                HttpStatus.SERVICE_UNAVAILABLE)
                                )
                                .filter((exchange, chain) -> chain.filter(exchange)
                                        .onErrorResume(throwable -> fallbackService.handleFallback(exchange)))
                        )
                        .uri("http://localhost:8089")
                )
                .build();
    }



}
