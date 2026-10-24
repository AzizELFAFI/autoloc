package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("agence")
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @GetMapping
    public List<Agence> listerAgence() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/getById/{idAgence}")
    public Agence getAgenceById(@PathVariable Long idAgence) {
        return agenceService.consulterAgenceById(idAgence);
    }

    @DeleteMapping("/delete/{idAgence}")
    public void deleteById(@PathVariable Long idAgence) {
        agenceService.supprimerAgenceById(idAgence);
    }
}
