package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDto;

import java.util.List;

public interface MaintenanceUsuarioService {

    List<UsuarioDto> findAllUsers();

    UsuarioDetailDto findUserById(int id);

    Boolean updateUser(UsuarioDto usuarioDto);

    Boolean deleteUser(int id);

    Boolean insertUser(UsuarioCreateDto usuarioCreateDto);


}
