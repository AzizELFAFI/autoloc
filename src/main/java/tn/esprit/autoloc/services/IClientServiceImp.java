package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repositories.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceImp implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Le client ne peut pas être null");
        }
        return clientRepository.save(client);
    }

    @Override
    public Client modifierClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Le client ne peut pas être null");
        }
        if (!clientRepository.existsById(client.getIdClient())) {
            throw new RuntimeException("Client non trouvé avec l'ID: " + client.getIdClient());
        }
        return clientRepository.save(client);
    }

    @Override
    public List<Client> consulterClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client consulterClientById(long idClient) {
        return clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + idClient));
    }

    @Override
    public void supprimerClientById(long idClient) {
        if (!clientRepository.existsById(idClient)) {
            throw new RuntimeException("Client non trouvé avec l'ID: " + idClient);
        }
        clientRepository.deleteById(idClient);
    }
}
