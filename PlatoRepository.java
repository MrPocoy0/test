package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
}
