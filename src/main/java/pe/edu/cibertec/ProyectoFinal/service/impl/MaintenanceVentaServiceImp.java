package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;
import pe.edu.cibertec.ProyectoFinal.entity.Venta;
import pe.edu.cibertec.ProyectoFinal.repository.VentaRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceVentaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceVentaServiceImp implements MaintenanceVentaService {

    @Autowired
    VentaRepository ventaRepository;


    @Override
    public List<VentaDto> findAllVentas() {
        List<VentaDto> ventas = new ArrayList<>();
        Iterable<Venta> iterable = ventaRepository.findAll();
        iterable.forEach(venta -> {
            VentaDto ventaDto = new VentaDto(
                    venta.getIdVenta(),
                    venta.getCantidadProducto(),
                    venta.getMontoTotal(),
                    venta.getContacto(),
                    venta.getTelefono(),
                    venta.getDireccion(),
                    venta.getFechaVenta());
            ventas.add(ventaDto);
        });

        return ventas;
    }

    @Override
    public VentaDto findVentaById(int id) {
       Optional<Venta> optional = ventaRepository.findById(id);
       return optional.map(venta -> new VentaDto(
               venta.getIdVenta(),
               venta.getCantidadProducto(),
               venta.getMontoTotal(),
               venta.getContacto(),
               venta.getTelefono(),
               venta.getDireccion(),
               venta.getFechaVenta())
       ).orElse(null);

    }

    @Override
    public Boolean updateVenta(VentaDto ventaDto) {
        Optional<Venta> optional = ventaRepository.findById(ventaDto.idVenta());
        return optional.map(
                venta -> {
                    venta.setCantidadProducto(ventaDto.cantidadProducto());
                    venta.setMontoTotal(ventaDto.montoTotal());
                    venta.setContacto(ventaDto.contacto());
                    venta.setTelefono(ventaDto.telefono());
                    venta.setDireccion(ventaDto.direccion());
                    venta.setFechaVenta(ventaDto.fechaVenta());

                    ventaRepository.save(venta);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean deleteVenta(int id) {
        return ventaRepository.findById(id).map(venta ->{
            ventaRepository.delete(venta);
            return true;
        }).orElse(false);
        
    }


}
