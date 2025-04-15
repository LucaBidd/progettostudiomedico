package com.luca.studiomedico.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PazienteDTO {

    private String id;
    
    @NotNull(message = "Il nome non può essere nullo")
    private String nome;

    @NotNull(message = "Il cognome non può essere nullo")
    private String cognome;

    @NotNull(message = "Il codice fiscale non può essere nullo")
    @Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$", message = "Il codice fiscale non è valido")
    private String codFiscale;
    
    private String telefono;

    @Email(message = "L'email non è valida")
    private String email;

    private String indirizzo;
}
