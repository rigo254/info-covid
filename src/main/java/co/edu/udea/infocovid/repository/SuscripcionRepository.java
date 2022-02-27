package co.edu.udea.infocovid.repository;

import co.edu.udea.infocovid.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuscripcionRepository extends JpaRepository <Suscripcion, Long>{
    Optional<Suscripcion> findById(Long id);
}
