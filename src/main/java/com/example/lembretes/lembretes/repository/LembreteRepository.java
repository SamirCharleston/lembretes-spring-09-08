package com.example.lembretes.lembretes.repository;

import com.example.lembretes.lembretes.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}