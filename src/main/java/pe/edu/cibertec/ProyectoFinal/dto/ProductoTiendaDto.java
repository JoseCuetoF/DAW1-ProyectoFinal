package pe.edu.cibertec.ProyectoFinal.dto;

public record ProductoTiendaDto(Integer idPro,
                                String urlImg,
                                String marca,
                                String categoria,
                                String nombre,
                                Integer stock,
                                Double precio) {
}
