package com.luca.studiomedico.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luca.studiomedico.enums.Specializzazione;
import com.luca.studiomedico.model.Medico;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String>{
    
    List<Medico> findByNomeStartingWithIgnoreCase(String nome);
    List<Medico> findBySpecializzazione(Specializzazione specializzazione);
    
}
