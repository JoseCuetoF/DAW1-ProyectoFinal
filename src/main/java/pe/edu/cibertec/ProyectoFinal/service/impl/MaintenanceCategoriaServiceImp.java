package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.CategoriaDto;
import pe.edu.cibertec.ProyectoFinal.entity.Categoria;
import pe.edu.cibertec.ProyectoFinal.repository.CategoriaRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceCategoriaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceCategoriaServiceImp implements MaintenanceCategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDto> getAllCategorias() {

        List<CategoriaDto> categorias = new ArrayList<CategoriaDto>();
        Iterable<Categoria> iterable = categoriaRepository.findAll();
        iterable.forEach(categoria -> {
            CategoriaDto categoriaDto = new CategoriaDto(categoria.getIdCategoria(),
                    categoria.getNombre(),
                    categoria.getActivo(),
                    categoria.getFechaRegistro());
            System.out.println("CategoriaDto creado: " + categoriaDto);
            categorias.add(categoriaDto);
        });
        return categorias;
    }
}
