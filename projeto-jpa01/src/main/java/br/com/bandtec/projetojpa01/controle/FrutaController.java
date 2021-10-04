package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Carro;
import br.com.bandtec.projetojpa01.dominio.Fruta;
import br.com.bandtec.projetojpa01.repositorio.CarroRepository;
import br.com.bandtec.projetojpa01.repositorio.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

    @Autowired
    private FrutaRepository repository;

    @GetMapping
    public ResponseEntity obterFrutas(){
        List<Fruta> frutas = repository.findAll();
        if (frutas.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(frutas);
        }
    }

    @PostMapping
    public ResponseEntity cadastrarFruta(@RequestBody Fruta fruta){
        repository.save(fruta);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity obterFrutaPorId(@PathVariable int id){
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFrutaPorId(@PathVariable int id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/contagem")
    public String contarFrutas(){
        List<Fruta> frutas = repository.findAll();
        return "Há um total de "+ repository.count() + " frutas cadastradas";
    }
}
