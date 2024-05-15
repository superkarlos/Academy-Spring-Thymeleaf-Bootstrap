package br.com.academy.model;

import br.com.academy.enuns.Curso;
import br.com.academy.enuns.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String nome;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String matricula;
    @Enumerated(EnumType.STRING)
    private Status status;
    
}
