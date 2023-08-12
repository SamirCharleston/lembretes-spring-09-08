package com.example.lembretes.lembretes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tb_pessoa", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @OneToMany
    private List<Lembrete> lembretes;
}
