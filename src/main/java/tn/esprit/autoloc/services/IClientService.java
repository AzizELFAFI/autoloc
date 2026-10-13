package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);
    Client modifierClient(Client client);
    List<Client> consulterClients();
    Client consulterClientById(long idClient);
    void supprimerClientById(long idClient);
}
