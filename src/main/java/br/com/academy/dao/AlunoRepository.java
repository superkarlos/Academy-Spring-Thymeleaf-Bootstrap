package br.com.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.AlunoEntity;

public interface AlunoRepository  extends JpaRepository<AlunoEntity,Long>{


    @Query("select j from AlunoEntity j where j.status = 'ATIVO'")
    public List<AlunoEntity> findByStatusAtivos();
    @Query("select j from AlunoEntity j where j.status = 'INATIVO'")
    public List<AlunoEntity> findByStatusInativos();
    @Query("select j from AlunoEntity j where j.status = 'TRANCADO'")
    public List<AlunoEntity> findByStatusTrancados();
    @Query("select j from AlunoEntity j where j.status = 'CANCELADO'")
    public List<AlunoEntity> findByStatusCancelados();
}


