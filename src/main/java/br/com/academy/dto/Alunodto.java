package br.com.academy.dto;

import br.com.academy.enuns.Curso;
import br.com.academy.enuns.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Alunodto(
    @Size(min=5 , max = 32, message = "O nome deve conter entre 5 e 32 letras")
    @NotBlank(message = "Nome não pode ser vazio")
     String nome,
     @Enumerated(EnumType.STRING)
     Curso curso, 
    String matricula,
    @Enumerated(EnumType.STRING)
    Status status
    
) {

}
