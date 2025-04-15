package com.luca.studiomedico.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "pazienti")
public class Paziente {

    @Id
    private String id;

    private String nome;
    private String cognome;
    private String codFiscale;
    private String telefono;
    private String email;
    private String indirizzo;

    
}
