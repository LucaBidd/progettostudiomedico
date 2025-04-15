package com.luca.studiomedico.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luca.studiomedico.enums.Status;
import com.luca.studiomedico.enums.TipoVisita;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "prenotazioni")
public class Prenotazione {

    @Id
    private String id;

    private String idPaziente;
    private String idMedico;
    private TipoVisita tipoVisita;
    private Status status;
    private Double costo;
    private LocalDate data;
    private LocalTime orario;
    private Integer durata;
    private String note;
}
