package pe.edu.cibertec.ProyectoFinal.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ProductoDetailDto(Integer idPro,
                                Integer idMarca,
                                Integer idCategoria,
                                String nombreMarca,
                                String nombreCategoria,
                                String nombre,
                                String detalles,
                                String urlImg,
                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                Date fechaRegistro,
                                Integer stock,
                                Double precio,
                                Integer activo) {
}
