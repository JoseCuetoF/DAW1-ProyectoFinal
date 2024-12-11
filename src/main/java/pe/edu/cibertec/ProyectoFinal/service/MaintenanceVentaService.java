package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;

import java.util.List;

public interface MaintenanceVentaService {

    List<VentaDto> findAllVentas();

    VentaDto findVentaById(int id);

    Boolean updateVenta(VentaDto ventaDto);

    Boolean deleteVenta(int id);


}
