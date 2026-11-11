package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.services.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("maintenance")
@Tag(name = "Gestion des maintenances", description = "CRUD")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Ajout d'un maintenance")
    @PostMapping
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> listerMaintenance() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/getById/{idMaintenance}")
    public Maintenance getMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.consulterMaintenanceById(idMaintenance);
    }

    @DeleteMapping("/delete/{idMaintenance}")
    public void deleteById(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenanceById(idMaintenance);
    }
}
