package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDto;

import java.util.List;

public interface MaintenanceUsuarioService {

    List<UsuarioDto> findAllUsers()throws Exception ;

    UsuarioDetailDto findUserById(int id)throws Exception ;

    Boolean updateUser(UsuarioDto usuarioDto)throws Exception ;

    Boolean deleteUser(int id)throws Exception ;

    Boolean insertUser(UsuarioCreateDto usuarioCreateDto)throws Exception ;


}
