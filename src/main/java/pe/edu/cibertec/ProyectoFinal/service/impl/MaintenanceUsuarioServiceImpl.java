package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDto;
import pe.edu.cibertec.ProyectoFinal.entity.Usuario;
import pe.edu.cibertec.ProyectoFinal.repository.UsuarioRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

import java.util.*;

@Service
public class MaintenanceUsuarioServiceImpl implements MaintenanceUsuarioService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public List<UsuarioDto> findAllUsers() throws Exception {
        List<UsuarioDto> users = new ArrayList<UsuarioDto>();
        Iterable<Usuario> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            UsuarioDto usuarioDto = new UsuarioDto(
                    user.getIdUsuario(),
                    user.getNombres(),
                    user.getApellidos(),
                    user.getCorreo(),
                    user.getFechaRegistro());
            users.add(usuarioDto);
        });
        return users;
    }

    @Override
    public UsuarioDetailDto findUserById(int id)throws Exception  {
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
    public Boolean updateUser(UsuarioDto usuarioDto)throws Exception  {
        Optional<Usuario> optional = userRepository.findById(usuarioDto.idUsuario());
        return optional.map(
                user -> {
                    user.setNombres(usuarioDto.nombres());
                    user.setApellidos(usuarioDto.apellidos());
                    user.setCorreo(usuarioDto.correo());
                    user.setFechaRegistro(new Date());

                    userRepository.save(user);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean deleteUser(int id) throws Exception {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean insertUser(UsuarioCreateDto usuarioCreateDto)throws Exception  {

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

}
