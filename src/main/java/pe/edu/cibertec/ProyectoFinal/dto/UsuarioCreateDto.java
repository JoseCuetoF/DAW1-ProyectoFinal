package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record UsuarioCreateDto(String nombres,
                               String apellidos,
                               String correo,
                               Date fechaRegistro) {
}
