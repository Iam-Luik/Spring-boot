package br.com.bandtec.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaisController {

    @GetMapping("exemplo")
    public Pais getExemplo() {
        Pais exemplo = new Pais("Brasil", 4, 3, 1);
        return exemplo;
    }

    @GetMapping("top3")
    public List<Pais> getTop3() {
        List<Pais> top3 = List.of(
                new Pais("EUA", 30, 20, 10),
                new Pais("China", 28, 18, 8),
                new Pais("EUA", 20, 15, 7)
        );
        return top3;
    }

    @GetMapping("cadastrar/{pais}/{ouro}/{prata}/{bronze}")
    public String cadastrar(@PathVariable String pais,
                            @PathVariable Integer ouro,
                            @PathVariable Integer prata,
                            @PathVariable Integer bronze){
        Pais novoPais = new Pais(pais, ouro, prata, bronze);
        return "Cadastrado com sucesso!";
    }
}
