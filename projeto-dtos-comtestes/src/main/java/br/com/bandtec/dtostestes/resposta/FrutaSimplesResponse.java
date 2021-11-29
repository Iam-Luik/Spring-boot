package br.com.bandtec.dtostestes.resposta;

// Esta classe é um DTO usado para o retorno (Response) de dados
public class FrutaSimplesResponse {

    private Integer id;
    private String nome;

    public FrutaSimplesResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
