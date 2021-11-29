package br.com.bandtec.dtostestes.controle;


import br.com.bandtec.dtostestes.dominio.Fruta;
import br.com.bandtec.dtostestes.repositorio.FrutaRepository;
import br.com.bandtec.dtostestes.requisicao.FrutaNovoPrecoRequest;
import br.com.bandtec.dtostestes.resposta.FrutaPrecoEstoqueResponse;
import br.com.bandtec.dtostestes.resposta.FrutaSimplesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

    @Autowired
    private FrutaRepository repository;

    @GetMapping
    public ResponseEntity get() {
        List<Fruta> frutas = repository.findAll();
        return frutas.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(frutas);
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        List<FrutaSimplesResponse> frutas = repository.listarSimples();
        return frutas.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(frutas);
    }

    @GetMapping("/preco-estoque")
    public ResponseEntity getPrecoEstoque() {
        List<FrutaPrecoEstoqueResponse> frutas = repository.listarPrecoEstoque();
        return frutas.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(frutas);
    }

    @GetMapping("/foto/{id}")
    public ResponseEntity getFoto(@PathVariable int id) {
        if (repository.existsById(id)) {

            byte[] foto = repository.fotoPorId(id);

            return ResponseEntity
                    .status(200)
                    .header("content-type", "image/jpeg")
                    .body(foto);
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/preco")
    public ResponseEntity patchPreco(@RequestBody FrutaNovoPrecoRequest novoPrecoRequest) {
        if (repository.existsById(novoPrecoRequest.getId())) {

            repository.atualizarPreco(novoPrecoRequest.getId(), novoPrecoRequest.getPreco());

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
