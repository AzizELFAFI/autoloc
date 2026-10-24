package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("paiement")
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping
    public List<Paiement> listerPaiement() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/getById/{idPaiement}")
    public Paiement getPaiementById(@PathVariable Long idPaiement) {
        return paiementService.consulterPaiementById(idPaiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deleteById(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiementById(idPaiement);
    }
}
