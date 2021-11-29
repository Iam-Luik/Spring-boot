package br.com.bandtec.dtostestes.resposta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// esta classe possui 2 testes ou 2 cenários de testes. Todos testes unitários (ou testes de unidade)
class FrutaPrecoEstoqueResponseTest {

    @Test
    @DisplayName("getValorTotalEstoque() deve retornar 'precoUnitario x quantidadeEstoque'")
    void getValorTotalEstoqueDeveRetornarCalculoCorreto() {
        // usaremos 2 objetos aqui só para dar mais certeza ao teste, mas bastaria 1
        FrutaPrecoEstoqueResponse response1 = new FrutaPrecoEstoqueResponse( "uva", 12.5, 100);
        FrutaPrecoEstoqueResponse response2 = new FrutaPrecoEstoqueResponse( "maçã", 9.0, 50);

        // verificações

        // verificando se é "getValorTotalEstoque()" da response1 é 12.5 x 100 = 1250.0
        assertEquals(1250.0, response1.getValorTotalEstoque());

        // verificando se é "getValorTotalEstoque()" da response2 é 9.0 x 50 = 450.0
        assertEquals(450.0, response2.getValorTotalEstoque());
    }

    @Test
    @DisplayName("Construtor não deve mudar o nome")
    void construtorNaoDeveMudarNome() {
        FrutaPrecoEstoqueResponse response = new FrutaPrecoEstoqueResponse("uva", 12.5, 100);

        // verificações

        // verificando se é "uva" o nome da response
        assertEquals("uva", response.getNome());
    }

}