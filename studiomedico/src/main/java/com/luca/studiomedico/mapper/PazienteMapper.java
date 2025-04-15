package com.luca.studiomedico.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.luca.studiomedico.dto.PazienteDTO;
import com.luca.studiomedico.model.Paziente;

@Mapper(componentModel = "spring")
public interface PazienteMapper {
    PazienteDTO entityToDTO(Paziente paziente);
    List<PazienteDTO> entityToDTO(Iterable<Paziente> pazienti);
    
    Paziente dtoToEntity(PazienteDTO pazienteDTO);
    List<Paziente> dtoToEntity(Iterable<PazienteDTO> pazientiDTO);
}
