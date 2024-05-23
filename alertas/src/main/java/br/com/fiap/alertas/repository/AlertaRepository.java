package br.com.fiap.alertas.repository;

import br.com.fiap.alertas.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    Optional<Alerta> findByTitulo(String titulo);

}
