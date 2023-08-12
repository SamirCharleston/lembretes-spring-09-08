package com.example.lembretes.lembretes.controller;
import com.example.lembretes.lembretes.dto.LembreteOutDTO;
import com.example.lembretes.lembretes.dto.PessoaInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {
    @GetMapping("/encontrar")
    ResponseEntity<String> find(@RequestParam("nome") String nome){
        try{
            return ResponseEntity.ok("Registrado!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause().getMessage());
        }
    }
    @PostMapping("/registrar")
    ResponseEntity<PessoaInDTO> save(@RequestBody PessoaInDTO pessoaInDTO){
        try{
            return ResponseEntity.ok(pessoaInDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(pessoaInDTO);
        }
    }
    @PutMapping("/atualizar")
    ResponseEntity<String> update(@RequestBody PessoaInDTO pessoaInDTO){
        try{
            return ResponseEntity.ok("Atualizado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause().getMessage());
        }
    }
    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam("id") Long id){
        try{
            return ResponseEntity.ok("Deletado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause().getMessage());
        }
    }
}
