package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.CategoriaDto;

import java.util.List;

public interface MaintenanceCategoriaService {

    List<CategoriaDto> getAllCategorias() throws Exception  ;
    Boolean deleteCategory(int id) throws Exception  ;
    Boolean addCategory(CategoriaDto categoriaDto) throws Exception  ;
}
