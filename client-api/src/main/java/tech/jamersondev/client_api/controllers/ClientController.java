package tech.jamersondev.client_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jamersondev.client_api.dto.ClientForm;
import tech.jamersondev.client_api.model.Client;
import tech.jamersondev.client_api.services.ClientService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<String>> listClients(){
        List<String> clients = Arrays.asList("Jamerson", "Luiza", "Edson");
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/clients-db")
    public Flux<Client> listClientsDatabase(){
        return this.clientService.getAllClients();
    }

    @PostMapping
    @Transactional
    public Mono<ResponseEntity<ClientForm>> create(@RequestBody ClientForm form, UriComponentsBuilder uriBuilder){
       return   clientService.saveClient(form)
                .map(client -> {
                    var uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
                    return ResponseEntity.created(uri).body(new ClientForm(client));
                });
    }
}
