package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Pais;
import br.com.bandtec.projetojpa01.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public String postPais(@RequestBody Pais novoPais) {
        repository.save(novoPais);
        return "Pais cadastrado";
    }

    @GetMapping
    public List<Pais> getPaises() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pais getPais(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deletePais(@PathVariable int id) {
        repository.deleteById(id);
        return "Pais Excluído";
    }
}
