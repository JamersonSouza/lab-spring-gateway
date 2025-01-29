package tech.jamersondev.client_api.dto;

import tech.jamersondev.client_api.model.Client;

public record ClientForm(String name) {

    public ClientForm(Client client) {
        this(client.getName());
    }
}
