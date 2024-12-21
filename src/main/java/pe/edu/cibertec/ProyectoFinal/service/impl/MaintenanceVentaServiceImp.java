package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDetailDto;
import pe.edu.cibertec.ProyectoFinal.entity.Cliente;
import pe.edu.cibertec.ProyectoFinal.entity.Distrito;
import pe.edu.cibertec.ProyectoFinal.entity.Venta;
import pe.edu.cibertec.ProyectoFinal.repository.ClienteRepository;
import pe.edu.cibertec.ProyectoFinal.repository.DistritoRepository;
import pe.edu.cibertec.ProyectoFinal.repository.VentaRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceVentaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceVentaServiceImp implements MaintenanceVentaService {

    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    DistritoRepository distritoRepository;

    @Override
    public List<VentaDto> findAllVentas() throws Exception  {
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
    public VentaDetailDto findVentaById(int id)throws Exception  {
       Optional<Venta> optional = ventaRepository.findById(id);
       return optional.map(venta -> new VentaDetailDto(
               venta.getIdVenta(),
               venta.getCliente().getIdCli(),
               venta.getCliente().getNombres(),
               venta.getCliente().getApellidos(),
               venta.getCantidadProducto(),
               venta.getMontoTotal(),
               venta.getContacto(),
               venta.getDistrito().getIdDistrito(),
               venta.getDistrito().getDescripcion(),
               venta.getTelefono(),
               venta.getDireccion(),
               venta.getIdTransaccion(),
               venta.getFechaVenta()
               )
       ).orElse(null);

    }

    @Override
    public Boolean updateVenta(VentaDetailDto ventaDetailDto)throws Exception  {
        Optional<Venta> optional = ventaRepository.findById(ventaDetailDto.idVenta());
        return optional.map(venta -> {
            // Actualizar los campos simples
            venta.setCantidadProducto(ventaDetailDto.cantidadProducto());
            venta.setMontoTotal(ventaDetailDto.montoTotal());
            venta.setMontoTotal(ventaDetailDto.montoTotal());
            venta.setContacto(ventaDetailDto.contacto());
            venta.setTelefono(ventaDetailDto.telefono());
            venta.setDireccion(ventaDetailDto.direccion());
            venta.setFechaVenta(ventaDetailDto.fechaVenta());

            // Actualizar la relación con Distrito (si aplica)
            if (ventaDetailDto.idDistrito() != null) {
                Optional<Distrito> distritoOptional = distritoRepository.findById(ventaDetailDto.idDistrito());
                distritoOptional.ifPresent(venta::setDistrito);
            }

            ventaRepository.save(venta);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean deleteVenta(int id)throws Exception  {
        return ventaRepository.findById(id).map(venta ->{
            ventaRepository.delete(venta);
            return true;
        }).orElse(false);
        
    }

    @Override
    public List<DistritoDto> findAllDistritos()throws Exception  {
        List<DistritoDto> distritos = new ArrayList<>();
        Iterable<Distrito> iterable = distritoRepository.findAll();

        iterable.forEach(distrito -> {
            DistritoDto distritoDto = new DistritoDto(
                    distrito.getIdDistrito(),
                    distrito.getDescripcion()
            );

            distritos.add(distritoDto);
        });

        return distritos;
    }


}
