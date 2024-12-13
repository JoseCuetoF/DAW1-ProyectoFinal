package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;

import java.util.List;

public interface MaintenanceVentaService {

    List<VentaDto> findAllVentas();

    VentaDetailDto findVentaById(int id);

    Boolean updateVenta(VentaDetailDto ventaDetailDto);

    Boolean deleteVenta(int id);

    // adicional
    List<DistritoDto> findAllDistritos();
}