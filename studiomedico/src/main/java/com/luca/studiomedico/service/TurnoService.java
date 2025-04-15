package com.luca.studiomedico.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.studiomedico.dto.TurnoDTO;
import com.luca.studiomedico.mapper.TurnoMapper;
import com.luca.studiomedico.model.Turno;
import com.luca.studiomedico.repository.TurnoRepository;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    // Costruttori
    public TurnoService(TurnoRepository turnoRepository, TurnoMapper turnoMapper) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
    }

    public List<TurnoDTO> getAll() {
        return turnoMapper.entityToDTO(turnoRepository.findAll());
    }
    
    public String createTurno(TurnoDTO turnoDTO){
        turnoRepository.save(turnoMapper.dtoToEntity(turnoDTO));
        return "Turno salvato correttamente";
    }

    public TurnoDTO updateTurno(String id, TurnoDTO turnoDTO){
        Turno turnoEsitente = turnoRepository.findById(turnoDTO.getId()).orElseThrow(()-> new RuntimeException("Turno non trovato"));
        
        turnoEsitente.setIdMedico(turnoDTO.getIdMedico());
        turnoEsitente.setGiorno(turnoDTO.getGiorno());
        turnoEsitente.setOrarioInizio(turnoDTO.getOrarioInizio());
        turnoEsitente.setOrarioFine(turnoDTO.getOrarioFine());

        Turno turnoAggiornato = turnoRepository.save(turnoEsitente);
        return turnoMapper.entityToDTO(turnoAggiornato);
    }

    public void deleteTurno(String id){
        Turno turnoEsitente = turnoRepository.findById(id).orElseThrow(()-> new RuntimeException("Turno non trovato"));
        turnoRepository.delete(turnoEsitente);
    }

    public TurnoDTO findById(String id){
        return turnoMapper.entityToDTO(turnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Turno non trovato")));
    }

    public List<TurnoDTO> findByIdMedico(String idMedico){
        return turnoMapper.entityToDTO(turnoRepository.findByIdMedico(idMedico));
    }

    public List<TurnoDTO> findByGiorno(DayOfWeek giorno){
        return turnoMapper.entityToDTO(turnoRepository.findByGiorno(giorno));
    }

    public List<TurnoDTO> findByOrarioInizio(LocalTime orarioInizio){
        return turnoMapper.entityToDTO(turnoRepository.findByOrarioInizio(orarioInizio));
    }

    public List<TurnoDTO> findByIdMedicoAndGiorno(String idMedico, LocalDate giorno){
        return turnoMapper.entityToDTO(turnoRepository.findByIdMedicoAndGiorno(idMedico, giorno));
    }
}
