package com.luca.studiomedico.dto;

import com.luca.studiomedico.enums.Specializzazione;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicoDTO {

    private String id;
	
    @NotNull(message = "Il nome non può essere nullo")
    private String nome;
    
    private Specializzazione specializzazione;
    
    private String telefono;

    @Email(message = "L'email non è valida")
    private String email;

}
