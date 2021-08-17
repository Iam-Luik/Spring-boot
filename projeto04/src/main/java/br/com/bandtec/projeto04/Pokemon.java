package br.com.bandtec.projeto04;

public class Pokemon {
    String nome;
    String tipo;
    Double forca;
    Boolean livre;

    public Pokemon(String nome, String tipo, Double forca, Boolean livre) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.livre = livre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }
}
