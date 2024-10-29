package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.DetallePedidos;

public interface DetallePedidosRepository extends JpaRepository<DetallePedidos, Long> {
}
