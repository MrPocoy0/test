package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
