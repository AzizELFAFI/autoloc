package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("paiement")
@Tag(name = "Gestion des paiements", description = "CRUD")
public class PaiementController {
    private final IPaiementService paiementService;

    @Operation(summary = "Ajout d'un paiement")
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
