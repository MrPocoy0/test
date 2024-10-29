package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.DetallePedidos;
import services.DetallePedidosService;

@RestController
@RequestMapping("/api/detalle_pedidos")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosService detallePedidosService;

    @GetMapping
    public List<DetallePedidos> getAllDetallePedidos() {
        return detallePedidosService.getAllDetallePedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidos> getDetallePedidoById(@PathVariable Long id) {
        DetallePedidos detallePedido = detallePedidosService.getDetallePedidoById(id)
                .orElseThrow(() -> new RuntimeException("DetallePedido not found with id " + id));
        return ResponseEntity.ok(detallePedido);
    }

    @PostMapping
    public DetallePedidos createDetallePedido(@RequestBody DetallePedidos detallePedido) {
        return detallePedidosService.createDetallePedido(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidos> updateDetallePedido(@PathVariable Long id, @RequestBody DetallePedidos detallePedidoDetails) {
        DetallePedidos updatedDetallePedido = detallePedidosService.updateDetallePedido(id, detallePedidoDetails);
        return ResponseEntity.ok(updatedDetallePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Long id) {
        detallePedidosService.deleteDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
