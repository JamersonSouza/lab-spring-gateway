package tech.jamersondev.client_api_alternative.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v2/clients")
public class ClientController {
    @GetMapping
    public ResponseEntity<List<String>> listClients(){
        List<String> clients = Arrays.asList("Jamerson", "Nathali", "Marinho");
        return ResponseEntity.ok(clients);
    }
}
