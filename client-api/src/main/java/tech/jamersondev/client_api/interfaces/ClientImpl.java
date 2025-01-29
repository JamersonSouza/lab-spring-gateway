package tech.jamersondev.client_api.interfaces;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jamersondev.client_api.dto.ClientForm;
import tech.jamersondev.client_api.model.Client;

public interface ClientImpl {


    Flux<Client> getAllClients();

    Mono<Client> saveClient(ClientForm client);


}
