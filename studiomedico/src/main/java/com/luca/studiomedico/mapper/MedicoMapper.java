package com.luca.studiomedico.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.luca.studiomedico.dto.MedicoDTO;
import com.luca.studiomedico.model.Medico;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    public MedicoDTO entityToDTO(Medico medico);
    public List<MedicoDTO> entityToDTO(Iterable<Medico> medico);
    
    public Medico dtoToEntity(MedicoDTO medicoDTO);
    public List<Medico> dtoToEntity(Iterable<MedicoDTO> medicoDTO);
}
