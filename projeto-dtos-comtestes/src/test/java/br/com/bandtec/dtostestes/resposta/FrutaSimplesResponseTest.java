package br.com.bandtec.dtostestes.resposta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// esta classe possui um testes ou um cenário de teste. É um teste unitário (ou teste de unidade)
class FrutaSimplesResponseTest {

    @Test
    @DisplayName("Construtor não deve mudar os atributos")
    void construtorNaoDeveMudarAtributos() {
        FrutaSimplesResponse response = new FrutaSimplesResponse(100, "uva");

        // verificações

        // verificando se é 100 o id da response
        assertEquals(100, response.getId());

        // verificando se é "uva" o nome da response
        assertEquals("uva", response.getNome());
    }

}