package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.CategoriaDto;
import pe.edu.cibertec.ProyectoFinal.entity.Categoria;
import pe.edu.cibertec.ProyectoFinal.entity.Usuario;
import pe.edu.cibertec.ProyectoFinal.repository.CategoriaRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceCategoriaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Boolean deleteCategory(int id) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoriaRepository.delete(categoria);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean addCategory(CategoriaDto categoriaDto) {

        try {
            Categoria categoria = new Categoria();
            categoria.setNombre(categoriaDto.nombre());
            categoria.setActivo(categoriaDto.activo());
            categoria.setFechaRegistro(new Date());

            categoriaRepository.save(categoria);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
