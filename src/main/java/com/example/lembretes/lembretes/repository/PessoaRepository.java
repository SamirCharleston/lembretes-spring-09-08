package com.example.lembretes.lembretes.repository;

import com.example.lembretes.lembretes.dto.PessoaOutDTO;
import com.example.lembretes.lembretes.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
    Pessoa findByName(@Param("nome") String nome);
}