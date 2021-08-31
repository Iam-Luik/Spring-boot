package com.example.C13adsaLuikCastroSilva01202054;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> lista = new ArrayList<Usuario>();


    @PostMapping
    public String cadastrarUsuario(@RequestBody Usuario novoUsuario) {
        this.lista.add(novoUsuario);
        return String.format("Usuário %s cadastrado com sucesso", novoUsuario.getNome());
    }

    @GetMapping
    public List<Usuario> exibirCadastradosOrdemAlfabetica(){
        List<Usuario> listaOrdenada = lista.stream().sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList());
        return listaOrdenada;
    }

    @PostMapping("/autenticacao/{login}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String login, @PathVariable String senha) {
        for (Usuario usuario : lista){
            if (usuario.login.equals(login) && usuario.senha.equals(senha)){
                usuario.setAutenticado(true);
                usuario.setAutenticadoEm(new Date());
                return usuario;
            }
        }
        return null;
    }

    @DeleteMapping("/autenticacao/{login}")
    public String removerAutenticacaoUsuario(@PathVariable String login){
        for (Usuario usuario : lista){
            if (usuario.login.equals(login) && usuario.autenticado.equals(true)){
                usuario.setAutenticado(false);
                usuario.setAutenticadoEm(null);
                return String.format("Usuário %s saiu do sistema", usuario.getNome());
            }
        }
        return String.format("Usuário %s não autenticado", login);
    }
}
