package br.com.bandtec.dtostestes.resposta;

// Esta classe é um DTO usado para o retorno (Response) de dados
public class FrutaPrecoEstoqueResponse {

    private String nome;
    private Double valorTotalEstoque;

    public FrutaPrecoEstoqueResponse(String nome, Double precoUnitario, Integer quantidadeEstoque) {
        this.nome = nome;
        this.valorTotalEstoque = precoUnitario * quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }
}
