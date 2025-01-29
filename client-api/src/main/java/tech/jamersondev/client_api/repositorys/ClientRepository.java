package tech.jamersondev.client_api.repositorys;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tech.jamersondev.client_api.model.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
