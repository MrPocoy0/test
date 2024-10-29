package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Sala;
import repositories.SalaRepository;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> getAllSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> getSalaById(Long id) {
        return salaRepository.findById(id);
    }

    public Sala createSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala updateSala(Long id, Sala salaDetails) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala not found with id " + id));

        sala.setNombre(salaDetails.getNombre());
        sala.setCapacidad(salaDetails.getCapacidad());

        return salaRepository.save(sala);
    }

    public void deleteSala(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala not found with id " + id));

        salaRepository.delete(sala);
    }
}
