package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Carro;
import br.com.bandtec.projetojpa01.dominio.Pais;
import br.com.bandtec.projetojpa01.repositorio.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @PostMapping
    public ResponseEntity postCarro(@RequestBody Carro novoCarro){
        repository.save(novoCarro);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getCarros() {
        List<Carro> carros = repository.findAll();
        if (carros.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(carros);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarro(@PathVariable int id){
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("/contagem")
    public String getContagem(){
        List<Carro> carros = repository.findAll();
        return "Há um total de "+ repository.count() + " carros cadastrados";
    }
}
