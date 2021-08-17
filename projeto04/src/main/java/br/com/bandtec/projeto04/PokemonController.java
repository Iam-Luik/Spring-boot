package br.com.bandtec.projeto04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private List<Pokemon> lista = new ArrayList<>(List.of(
            new Pokemon("Pikachu", "Raio", 20.0, true),
            new Pokemon("Charizard", "Fogo", 30.0, true),
            new Pokemon("Snorlax", "Normal", 5.0, false),
            new Pokemon("Cyndaquil", "Fogo", 7.0, false)
    ));

    public boolean existe(int indice){
        return (indice >= 0 && indice < lista.size()) ? true : false;
    }

    @GetMapping("/todos")
    public List<Pokemon> getTodos() {
        return this.lista;
    }

    @GetMapping("/recuperar/{indice}")
    public Pokemon getUm(@PathVariable int indice) {
        return (indice >0 && indice < lista.size()) ? lista.get(indice) : null;
    }

    @GetMapping("/excluir/{indice}")
    public String removeUm(@PathVariable int indice) {
        if (this.existe(indice)){
            this.lista.remove(indice);
            return "Pokemon removido";
        }
        else {
            return "Pokemon não encontrado";
        }
    }

    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{livre}")
    public String cadastrar(@PathVariable String nome,
                            @PathVariable String tipo,
                            @PathVariable Double forca,
                            @PathVariable Boolean livre) {
        Pokemon pokemon = new Pokemon(nome, tipo, forca, livre);
        lista.add(pokemon);
        return "Pokemon removido";
    }

    @GetMapping("/alterar/{indice}/{nome}/{tipo}/{forca}/{livre}")
    public String alterar(@PathVariable int indice,
                          @PathVariable String nome,
                          @PathVariable String tipo,
                          @PathVariable Double forca,
                          @PathVariable Boolean livre) {

        if (this.existe(indice)){
            lista.set(indice, new Pokemon(nome, tipo, forca, livre));
            return "Pokemon atualizado";
        }
        else {
            return "Pokemon não encontrado";
        }
    }

    @GetMapping("/todos/ordem-alfabetica")
    public List<Pokemon> ordemAlfabetica() {
        List<Pokemon> listaOrdenada = lista.stream().sorted(Comparator.comparing(Pokemon::getNome)).collect(Collectors.toList());
        return listaOrdenada;
    }

    @GetMapping("/todos/livres")
    public List<Pokemon> getLivres() {
        List<Pokemon> listaLivres = lista.stream().filter(pokemon -> pokemon.getLivre()).collect(Collectors.toList());

        return listaLivres;
    }

    @GetMapping("/todos/fortes")
    public List<Pokemon> getFortes() {
        List<Pokemon> listaFortes = lista.stream()
                .filter(pokemon -> pokemon.getForca() >= 1.0)
                .sorted(Comparator.comparing(Pokemon::getForca))
                .collect(Collectors.toList());

        return listaFortes;
    }

    @GetMapping("/contagem-presos")
    public Long getPresos(){
        return lista.stream().filter(pokemon -> !pokemon.getLivre()).count();
    }
}
