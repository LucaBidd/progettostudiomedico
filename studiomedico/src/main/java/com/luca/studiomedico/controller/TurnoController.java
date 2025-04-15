package com.luca.studiomedico.controller;

import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import com.luca.studiomedico.dto.TurnoDTO;
import com.luca.studiomedico.service.TurnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/turni")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<TurnoDTO> getAll() {
        return turnoService.getAll();
    }

    @PostMapping
    public String createTurno(@Valid @RequestBody TurnoDTO turnoDTO) {
        return turnoService.createTurno(turnoDTO);
    }

    @PutMapping("/{id}")
    public TurnoDTO updateTurno(@PathVariable @Valid String id, @Valid @RequestBody TurnoDTO turnoDTO) {
        return turnoService.updateTurno(id, turnoDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTurno(@PathVariable @Valid String id) {
        turnoService.deleteTurno(id);
        return "Turno eliminato correttamente";
    }

    @GetMapping("/{id}")
    public TurnoDTO getById(@PathVariable @Valid String id) {
        return turnoService.findById(id);
    }

    @GetMapping("filter/idMedico/{idMedico}")
    public List<TurnoDTO> findByIdMedico(@PathVariable @Valid String idMedico) {
        return turnoService.findByIdMedico(idMedico);
    }

    @GetMapping("filter/giorno/{giorno}")
    public List<TurnoDTO> findByGiorno(@PathVariable @Valid DayOfWeek giorno) {
        return turnoService.findByGiorno(giorno);
    }
/* 
 * 
 @GetMapping("filter/orarioInizio/{orarioInizio}")
 public List<TurnoDTO> findByOrarioInizio(@PathVariable @Valid LocalTime orarioInizio) {
    return turnoService.findByOrarioInizio(orarioInizio);
}

@GetMapping("filter/Med&Day/{idMedico}/{giorno}")
public List<TurnoDTO> findByIdMedicoAndGiorno(@PathVariable @Valid String idTurno, @PathVariable @Valid LocalDate giorno) {
    return turnoService.findByIdMedicoAndGiorno(idTurno, giorno);
}
*/
}
