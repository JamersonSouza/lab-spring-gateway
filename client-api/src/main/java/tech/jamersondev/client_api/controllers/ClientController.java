package tech.jamersondev.client_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping
    public ResponseEntity<List<String>> listClients(){
        List<String> clients = Arrays.asList("Jamerson", "Luiza", "Edson");
        return ResponseEntity.ok(clients);
    }
}
