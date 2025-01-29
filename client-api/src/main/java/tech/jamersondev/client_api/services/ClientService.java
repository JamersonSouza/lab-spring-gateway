package tech.jamersondev.client_api.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jamersondev.client_api.dto.ClientForm;
import tech.jamersondev.client_api.interfaces.ClientImpl;
import tech.jamersondev.client_api.model.Client;
import tech.jamersondev.client_api.repositorys.ClientRepository;

import java.util.UUID;

@Service
public class ClientService implements ClientImpl {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Flux<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Mono<Client> saveClient(ClientForm form) {
        Client client = new Client(UUID.randomUUID(), form.name());
        return this.clientRepository.save(client);
    }
}
