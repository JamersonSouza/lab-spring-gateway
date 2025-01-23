package tech.jamersondev.client_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping
    public void listClients(){
        Arrays.asList("Jamerson", "Tathyane", "Luiza").stream().forEach(System.out::println);
    }
}
