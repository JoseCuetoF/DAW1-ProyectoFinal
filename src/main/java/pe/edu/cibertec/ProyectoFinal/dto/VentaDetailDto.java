package pe.edu.cibertec.ProyectoFinal.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record VentaDetailDto(
        Integer idVenta,
        Integer idCliente,
        String nombreCliente,
        String apellidoCliente,
        Integer cantidadProducto,
        Double montoTotal,
        String contacto,
        Integer idDistrito,
        String nombreDistrito,
        Integer telefono,
        String direccion,
        String idTransaccion,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date fechaVenta) {
}
