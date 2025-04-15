package com.luca.studiomedico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.studiomedico.dto.PazienteDTO;
import com.luca.studiomedico.service.PazienteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/pazienti")
public class PazienteController {

    private final PazienteService pazienteService;

    public PazienteController(PazienteService pazienteService) {
        this.pazienteService = pazienteService;
    }

    @GetMapping
    public List<PazienteDTO> getAll() {
        return pazienteService.getAll();
    }

    @PostMapping
    public String createPaziente(@Valid @RequestBody PazienteDTO pazienteDTO) {
        return pazienteService.createPaziente(pazienteDTO);
    }

    @PutMapping("/{id}")
    public PazienteDTO updatePaziente(@PathVariable @Valid String id, @Valid @RequestBody PazienteDTO pazienteDTO) {
        return pazienteService.updatePaziente(id, pazienteDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePaziente(@PathVariable @Valid String id) {
        pazienteService.deletePaziente(id);
        return "Paziente eliminato correttamente";
    }

    @GetMapping("/{id}")
    public PazienteDTO getById(@PathVariable @Valid String id) {
        return pazienteService.findById(id);
    }

    @GetMapping("filter/cognome/{cognome}")
    public List<PazienteDTO> getByCognome(@PathVariable @Valid String cognome) {
        return pazienteService.findByCognome(cognome);
    }

    @GetMapping("filter/codFiscale/{codFiscale}")
    public List<PazienteDTO> getByCodFiscale(@PathVariable @Valid String codFiscale) {
        return pazienteService.findByCodFiscale(codFiscale);
    }

}
