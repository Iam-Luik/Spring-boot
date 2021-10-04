package com.example.c23adsaluikcastrosilva01202054.controller;

import com.example.c23adsaluikcastrosilva01202054.dominio.Musica;
import com.example.c23adsaluikcastrosilva01202054.repositorio.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @PostMapping
    public ResponseEntity cadastrarMusica(@RequestBody Musica novaMusica){
        repository.save(novaMusica);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity obterMusicaPorId(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerMusicaPorId(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity obterMusicas() {
        List<Musica> musicas = repository.findAll();
        if (musicas.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(musicas);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarMusica(@PathVariable int id, @RequestBody Musica musicaAtualizada) {
        if (repository.existsById(id)) {
            musicaAtualizada.setId(id);
            repository.save(musicaAtualizada);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/contagem")
    public String obterContagem(){
        return "Há um total de "+ repository.count() + " músicas cadastradas";
    }
}
