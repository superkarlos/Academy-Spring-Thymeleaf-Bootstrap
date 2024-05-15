package br.com.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academy.model.AlunoEntity;

public interface AlunoRepository  extends JpaRepository<AlunoEntity,Long>{
    
}
