package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("equipement")
@Tag(name = "Gestion des equipements", description = "CRUD")
public class EquipementController {
    private final IEquipementService equipementService;

    @Operation(summary = "Ajout d'un equipement")
    @PostMapping
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping
    public List<Equipement> listerEquipement() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/getById/{idEquipement}")
    public Equipement getEquipementById(@PathVariable Long idEquipement) {
        return equipementService.consulterEquipementById(idEquipement);
    }

    @DeleteMapping("/delete/{idEquipement}")
    public void deleteById(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipementById(idEquipement);
    }
}
