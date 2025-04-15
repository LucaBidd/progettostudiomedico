package com.luca.studiomedico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.studiomedico.dto.MedicoDTO;
import com.luca.studiomedico.enums.Specializzazione;
import com.luca.studiomedico.mapper.MedicoMapper;
import com.luca.studiomedico.model.Medico;
import com.luca.studiomedico.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    // Costruttori
    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }

    public List<MedicoDTO> getAll() {
        return medicoMapper.entityToDTO(medicoRepository.findAll());
    }
    
    public String createMedico(MedicoDTO medicoDTO){
        medicoRepository.save(medicoMapper.dtoToEntity(medicoDTO));
        return "Medico salvato correttamente";
    }

    public MedicoDTO updateMedico(String id, MedicoDTO medicoDTO){
        Medico medicoEsitente = medicoRepository.findById(medicoDTO.getId()).orElseThrow(()-> new RuntimeException("Medico non trovato"));
        
        medicoEsitente.setNome(medicoDTO.getNome());
        medicoEsitente.setSpecializzazione(medicoDTO.getSpecializzazione());
        medicoEsitente.setTelefono(medicoDTO.getTelefono());
        medicoEsitente.setEmail(medicoDTO.getEmail());

        Medico medicoAggiornato = medicoRepository.save(medicoEsitente);
        return medicoMapper.entityToDTO(medicoAggiornato);
    }

    public void deleteMedico(String id){
        Medico medicoEsitente = medicoRepository.findById(id).orElseThrow(()-> new RuntimeException("Medico non trovato"));
        medicoRepository.delete(medicoEsitente);
    }

    public MedicoDTO findById(String id){
        return medicoMapper.entityToDTO(medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico non trovato")));
    }

    public List<MedicoDTO> findByNome(String nome){
        return medicoMapper.entityToDTO(medicoRepository.findByNomeStartingWithIgnoreCase(nome));

    }
    public List<MedicoDTO> findBySpecializzazione(Specializzazione specializzazione){
        return medicoMapper.entityToDTO(medicoRepository.findBySpecializzazione(specializzazione));
    }}
