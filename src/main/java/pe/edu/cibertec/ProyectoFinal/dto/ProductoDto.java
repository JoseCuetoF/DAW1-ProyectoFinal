package pe.edu.cibertec.ProyectoFinal.dto;

public record ProductoDto(Integer idPro,
                                String marca,
                                String categoria,
                                String nombre,
                                Integer stock,
                                Double precio) {
}
