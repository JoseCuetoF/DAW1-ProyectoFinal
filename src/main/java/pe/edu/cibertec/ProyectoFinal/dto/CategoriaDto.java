package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record CategoriaDto(Integer idCategoria,
                           String productos,
                           String nombre,
                           Integer activo,
                           Date fechaRegistro) {
}
