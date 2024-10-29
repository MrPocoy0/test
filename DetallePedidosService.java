package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.DetallePedidos;
import repositories.DetallePedidosRepository;

@Service
public class DetallePedidosService {

    @Autowired
    private DetallePedidosRepository detallePedidosRepository;

    public List<DetallePedidos> getAllDetallePedidos() {
        return detallePedidosRepository.findAll();
    }

    public Optional<DetallePedidos> getDetallePedidoById(Long id) {
        return detallePedidosRepository.findById(id);
    }

    public DetallePedidos createDetallePedido(DetallePedidos detallePedido) {
        return detallePedidosRepository.save(detallePedido);
    }

    public DetallePedidos updateDetallePedido(Long id, DetallePedidos detallePedidoDetails) {
        DetallePedidos detallePedido = detallePedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetallePedido not found with id " + id));

        detallePedido.setPedidoId(detallePedidoDetails.getPedidoId());
        detallePedido.setPlatoId(detallePedidoDetails.getPlatoId());
        detallePedido.setCantidad(detallePedidoDetails.getCantidad());

        return detallePedidosRepository.save(detallePedido);
    }

    public void deleteDetallePedido(Long id) {
        DetallePedidos detallePedido = detallePedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetallePedido not found with id " + id));

        detallePedidosRepository.delete(detallePedido);
    }
}
