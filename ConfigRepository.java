package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Config;

public interface ConfigRepository extends JpaRepository<Config, Long> {
}
