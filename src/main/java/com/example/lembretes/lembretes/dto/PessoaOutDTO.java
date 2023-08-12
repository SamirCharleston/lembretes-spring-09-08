package com.example.lembretes.lembretes.dto;

import com.example.lembretes.lembretes.entity.Lembrete;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PessoaOutDTO {
    private Long id;
    private String nome;
    private List<Lembrete> lembretes;
}
