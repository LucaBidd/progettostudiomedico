package com.luca.studiomedico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.studiomedico.dto.PazienteDTO;
import com.luca.studiomedico.mapper.PazienteMapper;
import com.luca.studiomedico.model.Paziente;
import com.luca.studiomedico.repository.PazienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PazienteService {
    

    private final PazienteRepository pazienteRepository;
    private final PazienteMapper pazienteMapper;

	public List<PazienteDTO> getAll() {
        return pazienteMapper.entityToDTO(pazienteRepository.findAll());
    }
    
    public String createPaziente(PazienteDTO pazienteDTO){
        Paziente paziente = pazienteMapper.dtoToEntity(pazienteDTO);
        pazienteRepository.save(paziente);
        return "Paziente salvato correttamente";
    }

    public PazienteDTO updatePaziente(String id, PazienteDTO pazienteDTO){
        Paziente pazienteEsitente = pazienteRepository.findById(pazienteDTO.getId()).orElseThrow(()-> new RuntimeException("Paziente non trovato"));
        
        pazienteEsitente.setNome(pazienteDTO.getNome());
        pazienteEsitente.setCognome(pazienteDTO.getCognome());
        pazienteEsitente.setCodFiscale(pazienteDTO.getCodFiscale());
        pazienteEsitente.setEmail(pazienteDTO.getEmail());
        pazienteEsitente.setIndirizzo(pazienteDTO.getIndirizzo());
        pazienteEsitente.setTelefono(pazienteDTO.getTelefono());

        Paziente pazienteAggiornato = pazienteRepository.save(pazienteEsitente);
        return pazienteMapper.entityToDTO(pazienteAggiornato);
    }

    public void deletePaziente(String id){
        Paziente pazienteEsitente = pazienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Paziente non trovato"));
        pazienteRepository.delete(pazienteEsitente);
    }

    public PazienteDTO findById(String id){
        return pazienteMapper.entityToDTO(pazienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paziente non trovato")));
    }

    public List<PazienteDTO> findByCognome(String cognome){
        return pazienteMapper.entityToDTO(pazienteRepository.findByCognomeStartingWithIgnoreCase(cognome));
    }

    public List<PazienteDTO> findByCodFiscale(String codFiscale){
        return pazienteMapper.entityToDTO(pazienteRepository.findByCodFiscale(codFiscale));
    }
}
