package com.luca.studiomedico.dto;


import java.time.DayOfWeek;
import java.time.LocalTime;


import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurnoDTO {

    @NonNull
    private String id;

    @NonNull
    private String idMedico;

    @NotNull(message = "il giorno deve essere valido")
    private DayOfWeek giorno;

    @NotNull(message = "l'orario deve essere valido")
    private LocalTime orarioInizio;
    
    @NotNull(message = "l'orario deve essere valido")
    private LocalTime orarioFine;

}
