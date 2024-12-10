package pe.edu.cibertec.ProyectoFinal.dto;

public record ProductoDetailDto(Integer idPro,
                                Integer marca,
                                Integer categoria,
                                String nombre,
                                Integer stock,
                                Double precio) {
}
