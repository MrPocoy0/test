package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@SuppressWarnings("null")
	void deleteById(Long id);

	Usuario saveAll(Usuario usuario);

	@SuppressWarnings("null")
	Optional<Usuario> findById(Long id);

}
