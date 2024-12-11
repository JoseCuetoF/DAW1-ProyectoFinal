package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record ProductoDetailDto(Integer idPro,
                                String nombreMarca,
                                String nombreCategoria,
                                String nombre,
                                String detalles,
                                String urlImg,
                                Date fechaRegistro,
                                Integer stock,
                                Double precio,
                                Integer activo) {
}
