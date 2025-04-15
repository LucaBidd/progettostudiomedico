package com.luca.studiomedico.repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luca.studiomedico.model.Turno;

@Repository
public interface TurnoRepository extends MongoRepository<Turno, String>{

    List<Turno> findByIdMedico(String idMedico);
    List<Turno> findByGiorno(DayOfWeek giorno);
    List<Turno> findByOrarioInizio(LocalTime orarioInizio);
    List<Turno> findByIdMedicoAndGiorno(String idMedico, LocalDate giorno);
}
