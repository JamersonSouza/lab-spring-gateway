package tech.jamersondev.client_api_alternative.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/v2/clients")
public class ClientController {
    @GetMapping
    public void listClients(){
        Arrays.asList("Jamerson", "Nathali", "Marinho").stream().forEach(System.out::println);
    }
}
