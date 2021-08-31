package com.example.C13adsaLuikCastroSilva01202054;

import java.util.Date;

public class Usuario {
    String nome;
    String login;
    String senha;
    Boolean autenticado;
    Date autenticadoEm;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.autenticado = false;
        this.autenticadoEm = null;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getAutenticadoEm() {
        return autenticadoEm;
    }

    public void setAutenticadoEm(Date autenticadoEm) {
        this.autenticadoEm = autenticadoEm;
    }
}

