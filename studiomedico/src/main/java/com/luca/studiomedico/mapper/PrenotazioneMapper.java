package com.luca.studiomedico.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.luca.studiomedico.dto.PrenotazioneDTO;
import com.luca.studiomedico.model.Prenotazione;

@Mapper(componentModel = "spring")
public abstract class PrenotazioneMapper {

    public abstract PrenotazioneDTO entityToDTO(Prenotazione prenotazione);
    public abstract List<PrenotazioneDTO> entityToDTO(Iterable<Prenotazione> prenotazioni);
    
    public abstract Prenotazione dtoToEntity(PrenotazioneDTO prenotazioneDTO);
    public abstract List<Prenotazione> dtoToEntity(Iterable<PrenotazioneDTO> prenotazioniDTO);
}
