package com.example.lembretes.lembretes.service;

import com.example.lembretes.lembretes.dto.LembreteOutDTO;
import com.example.lembretes.lembretes.dto.PessoaInDTO;
import com.example.lembretes.lembretes.dto.PessoaOutDTO;
import com.example.lembretes.lembretes.entity.Lembrete;
import com.example.lembretes.lembretes.entity.Pessoa;
import com.example.lembretes.lembretes.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PessoaService {
    @Autowired
    PessoaRepository repository;
    public PessoaOutDTO findByName(String nome){
        Pessoa pessoa = repository.findByName(nome);
        if(pessoa == null){
            throw new EntityNotFoundException("Name not found");
        }
        PessoaOutDTO pessoaOutDTO = new PessoaOutDTO();
        pessoaOutDTO.setNome(pessoa.getNome());
        pessoaOutDTO.setId(pessoa.getId());
        return pessoaOutDTO;
    }
    public String savePerson(PessoaInDTO pessoaInDTO){
        if(repository.findByName(pessoaInDTO.getNome()) != null){
            throw new RuntimeException("Name already exists!");
        }
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaInDTO.getNome());
        repository.save(pessoa);
        return "Saved Success!";
    }
    public String updatePerson(String name, PessoaInDTO pessoaInDTO){
        Pessoa pessoa = repository.findByName(name);
        if(pessoaInDTO.getNome() == null && pessoaInDTO.getLembretes() == null){
            throw new RuntimeException("Needs at least one field!");
        }
        if(pessoaInDTO.getNome() != null){
            pessoa.setNome(pessoaInDTO.getNome());
        }
        if(pessoaInDTO.getLembretes() != null){
            pessoa.setLembretes(pessoaInDTO.getLembretes());
        }
        repository.save(pessoa);
        return "Updated Success!";
    }
    public String deletePerson(String nome){
        Pessoa pessoa = repository.findByName(nome);
        if(pessoa == null){
            throw new EntityNotFoundException("Name not found!");
        }
        repository.delete(pessoa);
        return "Deleted Success!";
    }
    public PessoaOutDTO encontrarLembretes(String name){
        PessoaOutDTO pessoaOutDTO = new PessoaOutDTO();
        Pessoa pessoa = repository.findByName(name);
        if(pessoa == null){
            throw new EntityNotFoundException("Name not found!");
        }
        pessoaOutDTO.setNome(name);
        pessoaOutDTO.setLembretes(pessoa.getLembretes());
        pessoaOutDTO.setId(pessoa.getId());
        return pessoaOutDTO;
    }
    public String insertMore(String name, String message){
        Pessoa pessoa = repository.findByName(name);
        if(pessoa == null){
            throw new EntityNotFoundException("Name not found!");
        }
        Lembrete lembrete = new Lembrete();
        lembrete.setRecado(message);
        pessoa.getLembretes().add(lembrete);
        repository.save(pessoa);
        return "Success!";
    }
    public List<LembreteOutDTO> encontrarLembretesLem(String name){
        Pessoa pessoa = repository.findByName(name);
        List<LembreteOutDTO> lembreteOutDTOS = new ArrayList<>();
        if(pessoa == null){
            throw new EntityNotFoundException("Name not found!");
        }
        for(Lembrete lembrete : pessoa.getLembretes()){
            LembreteOutDTO lembreteOutDTO = new LembreteOutDTO();
            lembreteOutDTO.setRecado(lembrete.getRecado());
            lembreteOutDTOS.add(lembreteOutDTO);
        }
        return lembreteOutDTOS;
    }
}
