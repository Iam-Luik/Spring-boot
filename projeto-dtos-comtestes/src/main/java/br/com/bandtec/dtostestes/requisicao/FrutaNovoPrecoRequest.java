package br.com.bandtec.dtostestes.requisicao;

// Esta classe é um DTO usado para o envio (Request) de dados
public class FrutaNovoPrecoRequest {

    private Integer id;
    private Double preco;

    public FrutaNovoPrecoRequest() {
    }

    public FrutaNovoPrecoRequest(Integer id, Double preco) {
        this.id = id;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }
}
