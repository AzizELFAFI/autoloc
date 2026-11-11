package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employe")
@Tag(name = "Gestion des employes", description = "CRUD")
public class EmployeController {
    private final IEmployeService employeService;

    @Operation(summary = "Ajout d'un employe")
    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> listerEmploye() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/getById/{idEmploye}")
    public Employe getEmployeById(@PathVariable Long idEmploye) {
        return employeService.consulterEmployeById(idEmploye);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public void deleteById(@PathVariable Long idEmploye) {
        employeService.supprimerEmployeById(idEmploye);
    }

    @PutMapping("/desaffecter/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PutMapping("affecter/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
