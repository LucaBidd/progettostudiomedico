package com.luca.studiomedico.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.luca.studiomedico.dto.TurnoDTO;
import com.luca.studiomedico.model.Turno;

@Mapper(componentModel = "spring")
public abstract class TurnoMapper {

    public abstract TurnoDTO entityToDTO(Turno turno);
    public abstract List<TurnoDTO> entityToDTO(Iterable<Turno> turni);
    
    public abstract Turno dtoToEntity(TurnoDTO turnoDTO);
    public abstract List<Turno> dtoToEntity(Iterable<TurnoDTO> turniDTO);
}
