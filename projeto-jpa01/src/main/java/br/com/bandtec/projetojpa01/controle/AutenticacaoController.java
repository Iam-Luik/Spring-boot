package br.com.bandtec.projetojpa01.controle;

import br.com.bandtec.projetojpa01.dominio.Autenticacao;
import br.com.bandtec.projetojpa01.dominio.Fruta;
import br.com.bandtec.projetojpa01.repositorio.AutenticacaoRepository;
import br.com.bandtec.projetojpa01.repositorio.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoRepository repository;


    @PostMapping("/usuarios")
    public ResponseEntity cadastraUsuario(@RequestBody Autenticacao autenticacao){
        repository.save(autenticacao);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticarUsuario(@RequestBody Autenticacao autenticacao){
        List<Autenticacao> usuarios = repository.findAll();
        for (Autenticacao usuario : usuarios){
            if (usuario.getLogin().equals(autenticacao.getLogin()) && usuario.getSenha().equals(autenticacao.getSenha())){
                usuario.setAutenticado(true);
                repository.save(usuario);
            }
        }
    }

}
