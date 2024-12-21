package pe.edu.cibertec.ProyectoFinal.service;

import pe.edu.cibertec.ProyectoFinal.dto.*;

import java.util.List;

public interface MaintenanceProductoService {

    List<ProductoDto> findAllProducts()throws Exception ;

    ProductoDetailDto findProductById(int id)throws Exception ;

    Boolean updateProduct(ProductoDetailDto productoDetailDto)throws Exception ;

    Boolean deleteProduct(int id)throws Exception ;

    Boolean insertProduct(ProductoCreateDto productoCreateDto)throws Exception ;

    //------------
    List<MarcaDto> getAllBrands()throws Exception ;
    List<CategoriaListDto> getAllCategories()throws Exception ;


    // ---------para tienda


    //Tienda
    List<ProductoTiendaDto> listProducts() ;

}
