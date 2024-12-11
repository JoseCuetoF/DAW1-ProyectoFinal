package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.*;

import java.util.List;

public interface MaintenanceProductoService {

    List<ProductoDto> findAllProducts();

    ProductoDetailDto findProductById(int id);

    Boolean updateProduct(ProductoUpdateDto productoUpdateDto);

    Boolean deleteProduct(int id);

    Boolean insertProduct(ProductoCreateDto productoCreateDto);

    //------------
    List<MarcaDto> getAllBrands();
    List<CategoriaListDto> getAllCategories();
}
