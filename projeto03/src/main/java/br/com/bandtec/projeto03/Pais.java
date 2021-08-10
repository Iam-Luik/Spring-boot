package br.com.bandtec.projeto03;

public class Pais {
    private String nome;
    private Integer ouro;
    private Integer prata;
    private Integer bronze;

    public Pais(String nome, Integer ouro, Integer prata, Integer bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }

    public String getNome() {
        return nome;
    }

    public Integer getOuro() {
        return ouro;
    }

    public Integer getPrata() {
        return prata;
    }

    public Integer getBronze() {
        return bronze;
    }

    public Integer getTotalMedalhas(){
        return ouro + prata + bronze;
    }
}
