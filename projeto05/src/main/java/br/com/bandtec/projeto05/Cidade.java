package br.com.bandtec.projeto05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private int id;
    private String nome;
    private int populacao;
    private boolean capital;
    private Estado estado;
    private List<String> pontosTuristicos = new ArrayList<>();
    private LocalDate fundacao;

    public Cidade(int id, String nome, int populacao, boolean capital, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.populacao = populacao;
        this.capital = capital;
        this.estado = estado;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public Cidade() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<String> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(List<String> pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }
}
