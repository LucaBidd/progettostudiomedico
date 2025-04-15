package com.luca.studiomedico.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luca.studiomedico.model.Paziente;
import java.util.List;

@Repository
public interface PazienteRepository extends MongoRepository<Paziente, String>{

    public List<Paziente> findByCognomeStartingWithIgnoreCase(String cognome);
    public List<Paziente> findByCodFiscale(String codFiscale);
}
