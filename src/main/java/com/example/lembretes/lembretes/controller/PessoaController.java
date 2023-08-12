package com.example.lembretes.lembretes.controller;
import com.example.lembretes.lembretes.dto.LembreteOutDTO;
import com.example.lembretes.lembretes.dto.PessoaInDTO;
import com.example.lembretes.lembretes.dto.PessoaOutDTO;
import com.example.lembretes.lembretes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;
    @GetMapping("/encontrar")
    ResponseEntity<PessoaOutDTO> find(@RequestParam("nome") String nome){
        try{
            return ResponseEntity.ok(pessoaService.findByName(nome));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
    @GetMapping("lembretes")
    ResponseEntity<PessoaOutDTO> encontrarLembretes(@RequestParam("nome") String nome){
        try{
            return ResponseEntity.ok(pessoaService.encontrarLembretes(nome));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
    @PostMapping("/registrar")
    ResponseEntity<String> save(@RequestBody PessoaInDTO pessoaInDTO){
        try{
            return ResponseEntity.ok(pessoaService.savePerson(pessoaInDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
    @PutMapping("/atualizar")
    ResponseEntity<String> update(@RequestBody String name,
                                  @RequestBody PessoaInDTO pessoaInDTO){
        try{
            return ResponseEntity.ok(pessoaService.updatePerson(name, pessoaInDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam("nome") String nome){
        try{
            return ResponseEntity.ok(pessoaService.deletePerson(nome));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
}
