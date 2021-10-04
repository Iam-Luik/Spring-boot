package br.com.bandtec.projetojpa01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cor;
    private Double pesoMedio;
    private Boolean comestivel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(Double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public Boolean getComestivel() {
        return comestivel;
    }

    public void setComestivel(Boolean comestivel) {
        this.comestivel = comestivel;
    }
}
