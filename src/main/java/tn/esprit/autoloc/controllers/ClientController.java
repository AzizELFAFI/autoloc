package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("client")
public class ClientController {
    private final IClientService clientService;

    @PostMapping
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping
    public List<Client> listerClient() {
        return clientService.consulterClients();
    }

    @GetMapping("/getById/{idClient}")
    public Client getClientById(@PathVariable Long idClient) {
        return clientService.consulterClientById(idClient);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteById(@PathVariable Long idClient) {
        clientService.supprimerClientById(idClient);
    }
}
