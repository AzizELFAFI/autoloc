package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employe")
public class EmployeController {
    private final IEmployeService employeService;

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
}
