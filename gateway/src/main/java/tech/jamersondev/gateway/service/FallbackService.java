package tech.jamersondev.gateway.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class FallbackService {

    private final HttpClient client = HttpClient.create();

    public Mono<Void> handleFallback(ServerWebExchange exchange) {
        String url = "http://localhost:8088/v2/clients";
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        exchange.getResponse().getHeaders().add("Content-Type", "application/json");
        return client.get().uri(url)
                .responseSingle((response, body) -> body.asString())
                .flatMap(responseBody -> {
                    return exchange.getResponse().writeWith(Mono.just(
                            exchange.getResponse()
                                    .bufferFactory()
                                    .wrap(responseBody.getBytes())));
                });
    }

}
