package com.luca.studiomedico.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.studiomedico.dto.PrenotazioneDTO;
import com.luca.studiomedico.enums.Status;
import com.luca.studiomedico.enums.TipoVisita;
import com.luca.studiomedico.mapper.PrenotazioneMapper;
import com.luca.studiomedico.model.Prenotazione;
import com.luca.studiomedico.repository.PazienteRepository;
import com.luca.studiomedico.repository.PrenotazioneRepository;


@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final PrenotazioneMapper prenotazioneMapper;


    // Costruttori
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, PrenotazioneMapper prenotazioneMapper) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.prenotazioneMapper = prenotazioneMapper;
    }

    public List<PrenotazioneDTO> getAll() {
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findAll());
    }
    
    public String createPrenotazione(PrenotazioneDTO prenotazioneDTO){
        prenotazioneRepository.save(prenotazioneMapper.dtoToEntity(prenotazioneDTO));
        return "Prenotazione salvata correttamente";
    }

    public PrenotazioneDTO updatePrenotazione(String id, PrenotazioneDTO prenotazioneDTO){
        Prenotazione prenotazioneEsitente = prenotazioneRepository.findById(prenotazioneDTO.getId()).orElseThrow(()-> new RuntimeException("Prenotazione non trovato"));
        
        prenotazioneEsitente.setIdPaziente(prenotazioneDTO.getIdPaziente());
        prenotazioneEsitente.setIdMedico(prenotazioneDTO.getIdMedico());
        prenotazioneEsitente.setTipoVisita(prenotazioneDTO.getTipoVisita());
        prenotazioneEsitente.setStatus(prenotazioneDTO.getStatus());
        prenotazioneEsitente.setCosto(prenotazioneDTO.getCosto());
        prenotazioneEsitente.setData(prenotazioneDTO.getData());
        prenotazioneEsitente.setOrario(prenotazioneDTO.getOrario());
        prenotazioneEsitente.setDurata(prenotazioneDTO.getDurata());
        prenotazioneEsitente.setNote(prenotazioneDTO.getNote());

        Prenotazione prenotazioneAggiornato = prenotazioneRepository.save(prenotazioneEsitente);
        return prenotazioneMapper.entityToDTO(prenotazioneAggiornato);
    }

    public void deletePrenotazione(String id){
        Prenotazione prenotazioneEsitente = prenotazioneRepository.findById(id).orElseThrow(()-> new RuntimeException("Prenotazione non trovato"));
        prenotazioneRepository.delete(prenotazioneEsitente);
    }

    public PrenotazioneDTO findById(String id){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenotazione non trovato")));
    }

    public List<PrenotazioneDTO> findByIdPaziente(String idPaziente){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findByIdPaziente(idPaziente));
    }

    public List<PrenotazioneDTO> findByIdMedico(String idMedico){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findByIdMedico(idMedico));
    }

    public List<PrenotazioneDTO> findByTipoVisita(TipoVisita tipoVisita){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findByTipoVisita(tipoVisita));
    }

    public List<PrenotazioneDTO> findByStatus(Status status){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findByStatus(status));
    }

    public List<PrenotazioneDTO> findByData(LocalDate data){
        return prenotazioneMapper.entityToDTO(prenotazioneRepository.findByData(data));
    }
}
