package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.entity.Distrito;
import pe.edu.cibertec.ProyectoFinal.repository.DistritoRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceDistritoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceDistritoServiceImp implements MaintenanceDistritoService {

    @Autowired
    DistritoRepository  distritoRepository;



    // FALTA AGREGAR

    @Override
    public List<DistritoDto> getAllDistrito() {
        List<DistritoDto> distritos = new ArrayList<DistritoDto>();
        Iterable<Distrito> iterable = distritoRepository.findAll();
        iterable.forEach(distrito -> {
            DistritoDto distritoDto = new DistritoDto(distrito.getIdDistrito(),
                    distrito.getDescripcion());

            distritos.add(distritoDto);
        });
        return distritos;
    }
}
