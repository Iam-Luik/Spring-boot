package br.com.bandtec.projeto05;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    private List<Cidade> cidades = new ArrayList<Cidade>(List.of(
            new Cidade(1, "São paulo", 22000000, true, new Estado ("SP", "São Paulo")),
            new Cidade(22, "Diadema", 1500000, false, new Estado("SP", "São Paulo")),
            new Cidade(33, "Curitiba", 250000, true, new Estado("PR", "Paraná")),
            new Cidade(44, "Santos", 22000000, false, new Estado("SP", "São Paulo")),
            new Cidade(55, "Jericoacoara", 310000, false, new Estado("CE", "Ceará"))
    ));

    @GetMapping
    public List<Cidade> getCidades() {
        return cidades;
    }

    @GetMapping("/{id}")
    public Cidade getCidade(@PathVariable int id) {
        return cidades.stream()
                .filter(cidade -> cidade.getId() == id)
                .findFirst().get();
    }

    @DeleteMapping("/{id}")
    public String deleteCidade(@PathVariable int id) {
       cidades.remove(
               cidades.stream()
                       .filter(cidade -> cidade.getId() == id)
                       .findFirst().get()
       );
       return "Cidade excluída";
    }

    @PostMapping
    public String criarCidade(@RequestBody Cidade novaCidade){
        novaCidade.setId(ThreadLocalRandom.current().nextInt(0,100));
        cidades.add(novaCidade);
        return "Cidade cadastro com id " + novaCidade.getId();
    }

    @PutMapping("/{id}")
    public String alterarCidade(@RequestBody Cidade novaCidade, @PathVariable int id){
        deleteCidade(id);
        novaCidade.setId(id);
        cidades.add(novaCidade);
        return "Cidade " + id + " alterada";
    }
}
