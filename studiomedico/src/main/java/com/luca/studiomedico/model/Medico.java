package com.luca.studiomedico.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luca.studiomedico.enums.Specializzazione;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "medici")
public class Medico {
    
    @Id
    private String id;

    private String nome;
    private Specializzazione specializzazione;
    private String telefono;
    private String email;
    
}
