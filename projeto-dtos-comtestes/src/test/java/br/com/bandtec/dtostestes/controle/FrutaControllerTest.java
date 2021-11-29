package br.com.bandtec.dtostestes.controle;

import br.com.bandtec.dtostestes.dominio.Fruta;
import br.com.bandtec.dtostestes.repositorio.FrutaRepository;
import br.com.bandtec.dtostestes.requisicao.FrutaNovoPrecoRequest;
import br.com.bandtec.dtostestes.resposta.FrutaSimplesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
A anotação @SpringBootTest é usada para testes de integração em projetos Spring Boot
o atributo classes é usado para identificar as classes envolvidas nos testes de integração

Esta classe possui 12 cenários de teste, todos testes de integração (ou testes integrados)
 */
@SpringBootTest(classes = {FrutaController.class, FrutaRepository.class})
class FrutaControllerTest {

    /*
    Como a FrutaController foi injetada com @Autowired indica que, nos testes, o "controller" será DE VERDADE
    Ou seja, será possível testar seu real comportamento
     */
    @Autowired
    FrutaController controller;

    /*
    Como a FrutaRepository foi injetada com @MockBean indica que, nos testes, o "repository" será "DE MENTIRINHA"
    Ou seja, ele não vai de verdade ao banco de dados. Ele é um MOCK (dublê) e fará o que "ensinarmos" ele a fazer.
    Ele não será o objeto de teste, mas é necessário que ele "faça de conta" que funciona
    para que possamos testar a FrutaController
     */
    @MockBean
    FrutaRepository repository;

    @Test
    void getDeveRetornarStatus204SemCorpo_seSemFrutas() {

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método findAll()
        Nesse caso, estamos "ensinando" ele a retornar uma lista vazia
         */
        when(repository.findAll()).thenReturn(new ArrayList<>());

        // o get() do FrutaController acaba invocando o findAll() da FrutaRepository
        ResponseEntity resposta = controller.get();

        // Verificações

        // é 204 o código de status de resposta do endpoint?
        assertEquals(204, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }

    @Test
    void getDeveRetornarStatus200ComCorpo_seHaFrutas() {

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método findAll()
        Nesse caso, estamos "ensinando" ele a retornar uma lista com 2 frutas "de mentirinha"
        Ou seja, 2 mocks de frutas (afinal, não precisam ser frutas de verdade)
         */
        List<Fruta> listaFrutasMock = List.of(mock(Fruta.class), mock(Fruta.class));
        when(repository.findAll()).thenReturn(listaFrutasMock);

        // o get() do FrutaController acaba invocando o findAll() da FrutaRepository
        ResponseEntity resposta = controller.get();

        // Verificações

        // é 200 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());

        // O corpo da resposta do endpoint é exatamente a lista que a repository entregou?
        assertEquals(listaFrutasMock, resposta.getBody());
    }

    @Test
    void getSimplesDeveRetornarStatus204SemCorpo_seSemFrutas() {

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método listarSimples()
        Nesse caso, estamos "ensinando" ele a retornar uma lista vazia
         */
        when(repository.listarSimples()).thenReturn(new ArrayList<>());

        // o getSimples() do FrutaController acaba invocando o listarSimples() da FrutaRepository
        ResponseEntity resposta = controller.getSimples();

        // Verificações

        // é 204 o código de status de resposta do endpoint?
        assertEquals(204, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }

    @Test
    void getSimplesDeveRetornarStatus200ComCorpo_seHaFrutas() {

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método listarSimples()
        Nesse caso, estamos "ensinando" ele a retornar uma lista com 2 FrutasSimples "de mentirinha"
        Ou seja, 2 mocks de frutas (afinal, não precisam ser FrutaSimples de verdade)
         */
        List<FrutaSimplesResponse> listaFrutasMock = List.of(mock(FrutaSimplesResponse.class), mock(FrutaSimplesResponse.class));
        when(repository.listarSimples()).thenReturn(listaFrutasMock);

        // o get() do FrutaController acaba invocando o listarSimples() da FrutaRepository
        ResponseEntity resposta = controller.getSimples();

        // Verificações

        // é 200 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());

        // O corpo da resposta do endpoint é exatamente a lista que a repository entregou?
        assertEquals(listaFrutasMock, resposta.getBody());
    }

    @Test
    void getFotoDeveRetornarStatus404SemCorpo_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;
        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar false
         */
        when(repository.existsById(idTeste)).thenReturn(false);

        // o getFoto() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.getFoto(idTeste);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(404, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }

    @Test
    void getFotoDeveRetornarStatus200ComCorpo_seIdExiste() {

        Integer idTeste = 900; // Id de fruta usado neste teste
        byte[] fotoMock = {0,1,0,1}; // foto mock (não é uma foto mas é um vetor de bytes válido)
        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar true
         */
        when(repository.existsById(idTeste)).thenReturn(true);

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método fotoPorId()
        Nesse caso, estamos "ensinando" ele a retornar o valor da fotoMock
         */
        when(repository.fotoPorId(idTeste)).thenReturn(fotoMock);

        // o getFoto() do FrutaController acaba invocando os existsById() e fotoPorId() da FrutaRepository
        ResponseEntity resposta = controller.getFoto(idTeste);

        // Verificações

        // é 200 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertEquals(fotoMock, resposta.getBody());
    }

    @Test
    void patchPrecoDeveRetornarStatus404_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;
        FrutaNovoPrecoRequest novoPrecoRequest = new FrutaNovoPrecoRequest(idTeste, 1500.0);

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar false
         */
        when(repository.existsById(idTeste)).thenReturn(false);

        // o patchPreco() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.patchPreco(novoPrecoRequest);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void patchDeveRetornarStatus200_seIdExiste() {

        Integer idTeste = 900; // Id de fruta usado neste teste
        FrutaNovoPrecoRequest novoPrecoRequest = new FrutaNovoPrecoRequest(idTeste, 1500.0);
        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar true
         */
        when(repository.existsById(idTeste)).thenReturn(true);


        // o patchPreco() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.patchPreco(novoPrecoRequest);

        // Verificações

        // é 200 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());
    }


    @Test
    void getIdDeveRetornarStatus404SemCorpo_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método findById()
        Nesse caso, estamos "ensinando" ele a retornar um Optional sem valor
         */
        when(repository.findById(idTeste)).thenReturn(Optional.empty());

        // o get() do FrutaController acaba invocando o findById() da FrutaRepository
        ResponseEntity resposta = controller.get(idTeste);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(404, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }

    @Test
    void getIdDeveRetornarStatus200ComCorpo_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;
        Fruta frutaMock = mock(Fruta.class); // fruta "de mentirinha" usada no teste

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método findById()
        Nesse caso, estamos "ensinando" ele a retornar um Optional cujo valor é a frutaMock
         */
        when(repository.findById(idTeste)).thenReturn(Optional.of(frutaMock));

        // o get() do FrutaController acaba invocando o findById() da FrutaRepository
        ResponseEntity resposta = controller.get(idTeste);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());

        // O corpo da resposta do endpoint é exatamente a Fruta que a repository entregou?
        assertEquals(frutaMock, resposta.getBody());
    }


    @Test
    void deleteDeveRetornarStatus404SemCorpo_seIdNaoExiste() {

        // Id de fruta usado neste teste
        Integer idTeste = 900;

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar false
         */
        when(repository.existsById(idTeste)).thenReturn(false);

        // o patchPreco() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.delete(idTeste);

        // Verificações

        // é 404 o código de status de resposta do endpoint?
        assertEquals(404, resposta.getStatusCodeValue());

        // é nulo o corpo da resposta do endpoint? Ou seja, o endpoint não devolveu nenhum corpo?
        assertNull(resposta.getBody());
    }

    @Test
    void deleteRetornarStatus200_seIdExiste() {

        Integer idTeste = 900; // Id de fruta usado neste teste

        /*
        Aqui estamos "ensinando" ao repository o que ele deve fazer quando alguém invocar set método existsById()
        Nesse caso, estamos "ensinando" ele a retornar true
         */
        when(repository.existsById(idTeste)).thenReturn(true);


        // o patchPreco() do FrutaController acaba invocando o existsById() da FrutaRepository
        ResponseEntity resposta = controller.delete(idTeste);

        // Verificações

        // é 200 o código de status de resposta do endpoint?
        assertEquals(200, resposta.getStatusCodeValue());
    }

}