package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record UsuarioDetailDto(Integer idUsuario,
                               String nombres,
                               String apellidos,
                               String correo,
                               Date fechaRegistro) {
}