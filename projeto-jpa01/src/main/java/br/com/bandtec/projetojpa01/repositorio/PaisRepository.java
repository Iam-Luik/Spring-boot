package br.com.bandtec.projetojpa01.repositorio;

import br.com.bandtec.projetojpa01.dominio.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
