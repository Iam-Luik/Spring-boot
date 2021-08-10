package br.com.bandtec.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {
    private Integer acessos = 0;
    private Integer passageiro = 0;

    @GetMapping("acessos")
    public String obterAcessos() {
        acessos++;
        return String.format("Acessos: %d", acessos);
    }

    @GetMapping("entrar/{quantidade}")
    public String entrar(@PathVariable Integer quantidade) {
        this.acessos = this.acessos + quantidade;
        return (this.acessos <= 12) ? "Entrada registrada" : "Limite de 12 alcançado";
    }

    @GetMapping("consultar/passageiros")
    public String consultar() {
        if (this.passageiro == 0) {
            return "Nenhum passageiro entrou ainda";
        }
        else {
            return "Existe " + this.passageiro + " passageiros registrados";
        }
    }

}
