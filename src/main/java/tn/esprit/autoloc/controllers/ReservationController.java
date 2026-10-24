package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("reservation")
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping
    public List<Reservation> listerReservation() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/getById/{idReservation}")
    public Reservation getReservationById(@PathVariable Long idReservation) {
        return reservationService.consulterReservationById(idReservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteById(@PathVariable Long idReservation) {
        reservationService.supprimerReservationById(idReservation);
    }
}
