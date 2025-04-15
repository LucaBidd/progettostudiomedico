package com.luca.studiomedico.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luca.studiomedico.enums.Status;
import com.luca.studiomedico.enums.TipoVisita;
import com.luca.studiomedico.model.Prenotazione;


@Repository
public interface PrenotazioneRepository extends MongoRepository<Prenotazione, String>{
    
    List<Prenotazione> findByIdPaziente(String idPaziente);
    List<Prenotazione> findByIdMedico(String idMedico);
    List<Prenotazione> findByTipoVisita(TipoVisita tipoVisita);
    List<Prenotazione> findByStatus(Status status);
    List<Prenotazione> findByData(LocalDate data);
}
