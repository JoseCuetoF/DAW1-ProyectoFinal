package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.entity.Usuario;
import pe.edu.cibertec.ProyectoFinal.repository.UsuarioRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceUsuarioServiceImpl implements MaintenanceUsuarioService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public List<UsuarioDetailDto> findAllUsers() {
        List<UsuarioDetailDto> users = new ArrayList<UsuarioDetailDto>();
        Iterable<Usuario> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            UsuarioDetailDto usuarioDetailDto = new UsuarioDetailDto(
                    user.getIdUsuario(),
                    user.getNombres(),
                    user.getApellidos(),
                    user.getCorreo(),
                    user.getFechaRegistro());
            users.add(usuarioDetailDto);
        });
        return users;
    }

    @Override
    public UsuarioDetailDto findUserById(int id) {
        Optional<Usuario> optional = userRepository.findById(id);
        return optional.map(user -> new UsuarioDetailDto(
                user.getIdUsuario(),
                user.getNombres(),
                user.getApellidos(),
                user.getCorreo(),
                user.getFechaRegistro())
        ).orElse(null);
    }

    @Override
    public Boolean updateUser(UsuarioDetailDto usuarioDetailDto) {
        Optional<Usuario> optional = userRepository.findById(usuarioDetailDto.idUsuario());
        return optional.map(
                user -> {
                    user.setNombres(usuarioDetailDto.nombres());
                    user.setApellidos(usuarioDetailDto.apellidos());
                    user.setCorreo(usuarioDetailDto.correo());
                    user.setFechaRegistro(new Date());

                    userRepository.save(user);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean deleteUser(int id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean insertUser(UsuarioCreateDto usuarioCreateDto) {

        try {
            Usuario user = new Usuario();
            user.setNombres(usuarioCreateDto.nombres());
            user.setApellidos(usuarioCreateDto.apellidos());
            user.setCorreo(usuarioCreateDto.correo());
            user.setFechaRegistro(new Date());

            userRepository.save(user);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean loginUser(String email, String password) {
        Optional<Usuario> optional = userRepository.findByCorreo(email);

        if (optional.isPresent()) {
            Usuario user = optional.get();


            if (user.getPassword().equals(password)) {
                return true; // Login exitoso
            }
        }
        return false; // Login fallido
    }
}
