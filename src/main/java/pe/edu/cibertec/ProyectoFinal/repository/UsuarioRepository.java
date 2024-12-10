package pe.edu.cibertec.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.ProyectoFinal.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);

}
