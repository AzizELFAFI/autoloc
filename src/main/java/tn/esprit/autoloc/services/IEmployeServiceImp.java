package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.EmployeRepository;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repositories.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> consulterEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe consulterEmployeById(long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public void supprimerEmployeById(long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye).orElse(null);
        Agence agence = agenceRepository.findById(idAgence).orElse(null);

        if (employe != null && agence != null) {
            employe.setAgence(agence);
            employeRepository.save(employe);
        }
        return null;
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye){
        Employe employe = employeRepository.findById(idEmploye).orElse(null);
        if (employe != null){
            employe.setAgence(null);
            employeRepository.save(employe);
        }
        return null;
    }
}
