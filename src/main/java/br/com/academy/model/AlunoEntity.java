package br.com.academy.model;

import br.com.academy.enuns.Curso;
import br.com.academy.enuns.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Alunos")
@Data
@NoArgsConstructor

public class AlunoEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
   // @Size(min=5 , max = 32, message = "O nome deve conter entre 5 e 32 letras")
  //  @NotBlank(message = "Nome não pode ser vazio")
    private String nome;
    @Enumerated(EnumType.STRING)
    private Curso curso;
   // @NotNull(message = "Click no butão de gerar")
 //  @NotBlank(message = "Nome não pode ser vazio")
    private String matricula;
    @Enumerated(EnumType.STRING)
    private Status status;
    
}
