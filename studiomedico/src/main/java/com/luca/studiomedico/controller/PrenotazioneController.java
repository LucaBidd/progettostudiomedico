package com.luca.studiomedico.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.luca.studiomedico.dto.PrenotazioneDTO;
import com.luca.studiomedico.enums.Status;
import com.luca.studiomedico.enums.TipoVisita;
import com.luca.studiomedico.model.Paziente;
import com.luca.studiomedico.model.Medico;
import com.luca.studiomedico.model.Prenotazione;
import com.luca.studiomedico.repository.PazienteRepository;
import com.luca.studiomedico.repository.MedicoRepository;
import com.luca.studiomedico.service.PrenotazioneService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final PazienteRepository pazienteRepository;
    private final MedicoRepository medicoRepository;

    public PrenotazioneController(PrenotazioneService prenotazioneService, PazienteRepository pazienteRepository, MedicoRepository medicoRepository) {
        this.prenotazioneService = prenotazioneService;
        this.pazienteRepository = pazienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @GetMapping
    public List<PrenotazioneDTO> getAll() {
        return prenotazioneService.getAll();
    }

    @PostMapping
    public String createPrenotazione(@Valid @RequestBody PrenotazioneDTO prenotazioneDTO) {
        return prenotazioneService.createPrenotazione(prenotazioneDTO);
    }

    @PutMapping("/{id}")
    public PrenotazioneDTO updatePrenotazione(@PathVariable @Valid String id, @Valid @RequestBody PrenotazioneDTO prenotazioneDTO) {
        return prenotazioneService.updatePrenotazione(id, prenotazioneDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePrenotazione(@PathVariable @Valid String id) {
        prenotazioneService.deletePrenotazione(id);
        return "Prenotazione eliminato correttamente";
    }

    @GetMapping("/{id}")
    public PrenotazioneDTO getById(@PathVariable @Valid String id) {
        PrenotazioneDTO prenotazioneDTO = prenotazioneService.findById(id);

        Paziente pazientePrenotato =  pazienteRepository.findById(prenotazioneDTO.getIdPaziente()).get();
        prenotazioneDTO.setNomePaziente(pazientePrenotato.getCognome() + " " + pazientePrenotato.getNome());

        Medico medicoPrenotato =  medicoRepository.findById(prenotazioneDTO.getIdMedico()).get();
        prenotazioneDTO.setNomeMedico(medicoPrenotato.getNome());

        return prenotazioneDTO;
    }

    @GetMapping("filter/idPaziente/{idPaziente}")
    public List<PrenotazioneDTO> findByIdPaziente(@PathVariable @Valid String idPaziente) {
        List<PrenotazioneDTO> listaPerPaziente = new ArrayList<>();
        for(PrenotazioneDTO p : prenotazioneService.findByIdPaziente(idPaziente)){
            listaPerPaziente.add(getById(p.getId()));
        }
        listaPerPaziente.isEmpty();
        return listaPerPaziente;
    }

    @GetMapping("filter/idMedico/{idMedico}")
    public List<PrenotazioneDTO> findByIdMedico(@PathVariable @Valid String idMedico) {
        List<PrenotazioneDTO> listaPerMedico = new ArrayList<>();
        for(PrenotazioneDTO p : prenotazioneService.findByIdMedico(idMedico)){
            listaPerMedico.add(getById(p.getId()));
        }
        return listaPerMedico;
    }

    @GetMapping("filter/tipoVisita/{tipoVisita}")
    public List<PrenotazioneDTO> findByTipoVisita(@PathVariable @Valid TipoVisita tipoVisita) {
        return prenotazioneService.findByTipoVisita(tipoVisita);
    }

    @GetMapping("filter/status/{status}")
    public List<PrenotazioneDTO> findByStatus(@PathVariable @Valid Status status) {
        return prenotazioneService.findByStatus(status);
    }

    @GetMapping("filter/data/{data}")
    public List<PrenotazioneDTO> findByData(@PathVariable @Valid LocalDate data) {
        return prenotazioneService.findByData(data);
    }
}
