package com.example.lembretes.lembretes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_lembrete", schema = "public")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String recado;
}
