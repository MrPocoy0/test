package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Plato;
import repositories.PlatoRepository;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    public Optional<Plato> getPlatoById(Long id) {
        return platoRepository.findById(id);
    }

    public Plato createPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public Plato updatePlato(Long id, Plato platoDetails) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato not found with id " + id));

        plato.setNombre(platoDetails.getNombre());
        plato.setPrecio(platoDetails.getPrecio());
        plato.setDescripcion(platoDetails.getDescripcion());

        return platoRepository.save(plato);
    }

    public void deletePlato(Long id) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato not found with id " + id));

        platoRepository.delete(plato);
    }
}
