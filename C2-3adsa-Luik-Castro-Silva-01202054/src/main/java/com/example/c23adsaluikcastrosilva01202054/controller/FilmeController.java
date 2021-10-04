package com.example.c23adsaluikcastrosilva01202054.controller;

import com.example.c23adsaluikcastrosilva01202054.dominio.Filme;
import com.example.c23adsaluikcastrosilva01202054.repositorio.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository repository;

    @PostMapping
    public ResponseEntity cadastrarFilme(@RequestBody Filme novoFilme){
        repository.save(novoFilme);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity obterFilmePorId(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerFilmePorId(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity obterFilmes() {
        List<Filme> filmes = repository.findAll();
        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(filmes);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarFilme(@PathVariable int id, @RequestBody Filme filmeAtualizado) {
        if (repository.existsById(id)) {
            filmeAtualizado.setId(id);
            repository.save(filmeAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/contagem")
    public String obterContagem(){
        return "Há um total de "+ repository.count() + " filmes cadastrados";
    }
}
