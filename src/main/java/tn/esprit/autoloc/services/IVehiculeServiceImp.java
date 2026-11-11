package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.VehiculeRepository;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repositories.EquipementRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> consulterVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule consulterVehiculeById(long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public void supprimerVehiculeById(long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);

        if (vehicule != null && equipement != null) {
            if (!vehicule.getEquipements().contains(equipement)) {
                vehicule.getEquipements().add(equipement);
            }
            vehiculeRepository.save(vehicule);
        }

        return null;
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
       Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
       Equipement  equipement = equipementRepository.findById(idEquipement).orElse(null);

       if (vehicule != null && equipement != null) {
           if (!vehicule.getEquipements().contains(equipement)) {
               vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
               return vehiculeRepository.save(vehicule);
           }
       }
       return null;
    }
}
