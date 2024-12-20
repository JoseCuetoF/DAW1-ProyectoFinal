package pe.edu.cibertec.ProyectoFinal.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CategoriaDto(Integer idCategoria,
                           String nombre,
                           Integer activo,
                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                           Date fechaRegistro) {
}
