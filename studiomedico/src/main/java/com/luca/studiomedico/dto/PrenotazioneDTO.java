package com.luca.studiomedico.dto;

import com.luca.studiomedico.enums.TipoVisita;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.luca.studiomedico.enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrenotazioneDTO {

    private String id;

    @NotNull
    private String idPaziente;

    private String nomePaziente;
    private String nomeMedico;
    
    @NotNull
    private String idMedico;
    
    @NotNull(message = "Il tipo di visita deve essere valido")
    private TipoVisita tipoVisita;

    @NotNull(message = "Lo status deve essere valido")
    private Status status;

    private Double costo;

    private LocalDate data;

    @NotNull(message = "l'orario non può essere vuoto")
    private LocalTime orario;

    @NotNull(message = "l'orario non può essere vuoto")
    private Integer durata; // Durata in minuti
    
    private String note;
}
