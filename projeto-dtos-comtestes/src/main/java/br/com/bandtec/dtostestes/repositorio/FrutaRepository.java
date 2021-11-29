package br.com.bandtec.dtostestes.repositorio;

import br.com.bandtec.dtostestes.dominio.Fruta;
import br.com.bandtec.dtostestes.resposta.FrutaPrecoEstoqueResponse;
import br.com.bandtec.dtostestes.resposta.FrutaSimplesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FrutaRepository extends JpaRepository<Fruta, Integer> {

    @Query("select new br.com.bandtec.projetodtos.resposta.FrutaSimplesResponse(f.id, f.nome) from Fruta f")
    List<FrutaSimplesResponse> listarSimples();

    @Query("select new br.com.bandtec.projetodtos.resposta.FrutaPrecoEstoqueResponse(f.nome, f.precoUnitario, f.quantidadeEstoque) from Fruta f")
    List<FrutaPrecoEstoqueResponse> listarPrecoEstoque();

    @Query("select f.foto from Fruta f where f.id = ?1")
    byte[] fotoPorId(Integer id);

    // as anotações @Transactional e @Modifying são necessárias para operações de alteração de dados (como update, por exemplo)
    @Transactional // do pacote org.spring....
    @Modifying
    @Query("update Fruta f set f.precoUnitario = ?2 where f.id = ?1")
    void atualizarPreco(Integer id, Double novoPreco);

}
