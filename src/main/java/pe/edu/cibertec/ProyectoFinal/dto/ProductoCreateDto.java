package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record ProductoCreateDto(Integer idPro,
                                Integer idMarca,
                                Integer idCategoria,
                                String nombre,
                                String detalles,
                                String urlImg,
                                Date fechaRegistro,
                                Integer stock,
                                Double precio,
                                Integer activo) {
}
