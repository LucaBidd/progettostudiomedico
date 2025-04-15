
package com.luca.studiomedico.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "turni")
public class Turno {
    
    @Id
    private String id;

    private String idMedico;
    private DayOfWeek giorno;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;
    
}
