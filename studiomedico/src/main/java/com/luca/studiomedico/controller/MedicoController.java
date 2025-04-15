package com.luca.studiomedico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.studiomedico.dto.MedicoDTO;
import com.luca.studiomedico.enums.Specializzazione;
import com.luca.studiomedico.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/medici")
public class MedicoController {

    private final MedicoService medicoService;

    // Costruttore per l'iniezione della dipendenza
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    
    @GetMapping
    public List<MedicoDTO> getAll() {
        return medicoService.getAll();
    }

    @PostMapping
    public String createMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        return medicoService.createMedico(medicoDTO);
    }

    @PutMapping("/{id}")
    public MedicoDTO updateMedico(@PathVariable @Valid String id, @Valid @RequestBody MedicoDTO medicoDTO) {
        return medicoService.updateMedico(id, medicoDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteMedico(@PathVariable @Valid String id) {
        medicoService.deleteMedico(id);
        return "Medico eliminato correttamente";
    }
    
    @GetMapping("/{id}")
    public MedicoDTO getById(@PathVariable @Valid String id) {
        return medicoService.findById(id);
    }

    @GetMapping("filter/nome/{nome}")
    public List<MedicoDTO> findByNome(@PathVariable @Valid String nome) {
        return medicoService.findByNome(nome);
    }

    @GetMapping("filter/spec/{specializzazione}")
    public List<MedicoDTO> findBySpecializzazione(@PathVariable @Valid Specializzazione specializzazione) {
        return medicoService.findBySpecializzazione(specializzazione);
    }
}
