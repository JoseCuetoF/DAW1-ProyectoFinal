package pe.edu.cibertec.ProyectoFinal.dto;

import java.util.Date;

public record VentaDto(Integer idVenta,
                       Integer cantidadProducto,
                       Double montoTotal,
                       String contacto,
                       Integer telefono,
                       String direccion,
                       Date fechaVenta) {
}
