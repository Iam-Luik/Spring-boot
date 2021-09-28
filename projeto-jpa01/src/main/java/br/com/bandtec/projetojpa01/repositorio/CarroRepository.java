package br.com.bandtec.projetojpa01.repositorio;

import br.com.bandtec.projetojpa01.dominio.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
