package br.com.bandtec.projetojpa01.repositorio;

import br.com.bandtec.projetojpa01.dominio.Carro;
import br.com.bandtec.projetojpa01.dominio.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrutaRepository extends JpaRepository<Fruta, Integer> {
}
