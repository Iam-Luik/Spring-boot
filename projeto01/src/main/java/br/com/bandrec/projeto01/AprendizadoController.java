package br.com.bandrec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//A anotação @RestController indica que serão programados EndPoints na classe


@RestController
public class AprendizadoController  {

    //a anotação @GetMapping transforma um método em EndPoint
    //Neste caso, a URI é frase. (localhost:9090/frase)
    @GetMapping("frase")
    public String frase(){
        return "<b>É nois no spring boot!</b>";
    }

    @GetMapping("despedida")
    public String despedida(){
        return "<b>Tchau tchau!</b>";
    }

    @GetMapping("somar/{n1}/{n2}")
    public String somar(@PathVariable Double n1, @PathVariable Double n2){
        return "A soma dá: "+(n1+n2);
    }

    // path params --> {num}
    @GetMapping("elevar-quadrado/{num}")
    public String elevarQuadrado(@PathVariable Double num){
        return num + " ao quadrado é " + (num * num);
    }

    @GetMapping("dividir/{n1}/{n2}")
    public String dividir(@PathVariable Double n1, @PathVariable Double n2){
        return (n2 != 0.0) ? n1 + "/" + n2 + " dá " + (n1 / n2) : "Não posso dividr por 0(zero)!";
    }

    @GetMapping("resultado/{estudante}/{n1}/{n2}")
    public String dividir(@PathVariable String estudante, @PathVariable Double n1, @PathVariable Double n2){
        return ((n1+n2)/2 >= 6)
                ? String.format("Muito bem, %s você passou de semestre!", estudante)
                : String.format("%s, infelizmente você não passou :(");
    }
}
