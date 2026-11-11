package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vehicule")
@Tag(name = "Gestion des vehicules", description = "CRUD")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @Operation(summary = "Ajout d'un vehicule")
    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping
    public List<Vehicule> listerVehicule() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/getById/{idVehicule}")
    public Vehicule getVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.consulterVehiculeById(idVehicule);
    }

    @DeleteMapping("/delete/{idVehicule}")
    public void deleteById(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehiculeById(idVehicule);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}
