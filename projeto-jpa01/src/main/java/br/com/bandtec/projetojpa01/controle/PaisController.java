package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Pais;
import br.com.bandtec.projetojpa01.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public ResponseEntity postPais(@RequestBody Pais novoPais) {
        repository.save(novoPais);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getPaises() {
        List<Pais> paises = repository.findAll();
        if (paises.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(paises);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPais(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePais(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putPais(@PathVariable int id,
                          @RequestBody Pais paisAtualizado) {
        if (repository.existsById(id)) {
            paisAtualizado.setId(id);
            repository.save(paisAtualizado);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
