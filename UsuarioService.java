package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Usuario;
import repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll111() {
        return ((UsuarioService) usuarioRepository).findAll1();
    }

    public Optional<Usuario> findById(Long id) {
        return Optional.empty();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.saveAll(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteAll();
    }

	public List<Usuario> findAll1() {
		return null;
	}

	public List<Usuario> findAll() {
		
		return null;
	}
}
