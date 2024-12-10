package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;

import java.util.List;

public interface MaintenanceUsuarioService {

    List<UsuarioDetailDto> findAllUsers();

    UsuarioDetailDto findUserById(int id);

    Boolean updateUser(UsuarioDetailDto usuarioDetailDto);

    Boolean deleteUser(int id);

    Boolean insertUser(UsuarioCreateDto usuarioCreateDto);


}
