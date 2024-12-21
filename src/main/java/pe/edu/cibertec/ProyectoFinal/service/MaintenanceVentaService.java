package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;

import java.util.List;

public interface MaintenanceVentaService {

    List<VentaDto> findAllVentas()throws Exception ;

    VentaDetailDto findVentaById(int id)throws Exception ;

    Boolean updateVenta(VentaDetailDto ventaDetailDto)throws Exception ;

    Boolean deleteVenta(int id)throws Exception ;

    // adicional
    List<DistritoDto> findAllDistritos()throws Exception ;

}