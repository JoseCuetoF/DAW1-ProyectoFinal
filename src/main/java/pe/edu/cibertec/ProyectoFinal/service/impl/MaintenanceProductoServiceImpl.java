package pe.edu.cibertec.ProyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinal.dto.*;
import pe.edu.cibertec.ProyectoFinal.entity.Categoria;
import pe.edu.cibertec.ProyectoFinal.entity.Marca;
import pe.edu.cibertec.ProyectoFinal.entity.Producto;
import pe.edu.cibertec.ProyectoFinal.repository.CategoriaRepository;
import pe.edu.cibertec.ProyectoFinal.repository.MarcaRepository;
import pe.edu.cibertec.ProyectoFinal.repository.ProductoRepository;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceProductoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceProductoServiceImpl implements MaintenanceProductoService {

    @Autowired
    MarcaRepository marcaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;


    @Override
    public List<ProductoDto> findAllProducts() {
        List<ProductoDto> products = new ArrayList<ProductoDto>();
        Iterable<Producto> iterable = productoRepository.findAll();
        iterable.forEach(producto -> {
            ProductoDto productoDto = new ProductoDto(
                producto.getIdPro(),
                producto.getMarca().getNombre(),
                producto.getCategoria().getNombre(),
                producto.getNombre(),
                producto.getStock(),
                producto.getPrecio(),
                producto.getUrlImg()
            );
            products.add(productoDto);
        });
        return products;
    }

    @Override
    public ProductoDetailDto findProductById(int id) {
        Optional<Producto> optional = productoRepository.findById(id);
        return optional.map(producto -> new ProductoDetailDto(
                producto.getIdPro(),
                producto.getMarca().getIdMarca(),
                producto.getMarca().getIdMarca(),
                producto.getMarca().getNombre(),
                producto.getCategoria().getNombre(),
                producto.getNombre(),
                producto.getDetalles(),
                producto.getUrlImg(),
                producto.getFechaRegistro(),
                producto.getStock(),
                producto.getPrecio(),
                producto.getActivo())
        ).orElse(null);
    }

    @Override
    public Boolean updateProduct(ProductoDetailDto productoDetailDto) {
        Optional<Producto> optional = productoRepository.findById(productoDetailDto.idPro());
        return optional.map(
                producto -> {

                    Marca marca = marcaRepository.findById(productoDetailDto.idMarca())
                            .orElseThrow(() -> new IllegalArgumentException("marca no valida"));
                    Categoria categoria = categoriaRepository.findById(productoDetailDto.idCategoria())
                            .orElseThrow(() -> new IllegalArgumentException("categoria no valida"));

                    producto.setIdPro(productoDetailDto.idPro());
                    producto.setMarca(marca);
                    producto.setCategoria(categoria);
                    producto.setNombre(productoDetailDto.nombre());
                    producto.setDetalles(productoDetailDto.detalles());
                    producto.setUrlImg(productoDetailDto.urlImg());
                    producto.setFechaRegistro(new Date());
                    //producto.setFechaRegistro(new Date());
                    producto.setStock(productoDetailDto.stock());
                    producto.setPrecio(productoDetailDto.precio());
                    producto.setActivo(productoDetailDto.activo());

                    productoRepository.save(producto);
                    return true;
                }

        ).orElse(false);
    }

    @Override
    public Boolean deleteProduct(int id) {
        return productoRepository.findById(id).map(producto -> {
            productoRepository.delete(producto);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean insertProduct(ProductoCreateDto productoCreateDto) {
        try {

            Producto producto = new Producto();

            Marca marca = marcaRepository.findById(productoCreateDto.idMarca())
                    .orElseThrow(() -> new IllegalArgumentException("marca no valida"));
            Categoria categoria = categoriaRepository.findById(productoCreateDto.idCategoria())
                    .orElseThrow(() -> new IllegalArgumentException("categoria no valida"));

            producto.setMarca(marca);
            producto.setCategoria(categoria);
            producto.setNombre(productoCreateDto.nombre());
            producto.setDetalles(productoCreateDto.detalles());
            producto.setUrlImg(productoCreateDto.urlImg());
            producto.setFechaRegistro(new Date());
            producto.setStock(productoCreateDto.stock());
            producto.setPrecio(productoCreateDto.precio());
            producto.setActivo(productoCreateDto.activo());

            productoRepository.save(producto);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //------ADICIONAL PARA FORMULARIO

    @Override
    public List<MarcaDto> getAllBrands() {
        List<MarcaDto> marcas = new ArrayList<MarcaDto>();
        Iterable<Marca> iterable = marcaRepository.findAll();
        iterable.forEach( marca -> {
            MarcaDto marcaDto = new MarcaDto(marca.getIdMarca(), marca.getNombre());
            marcas.add(marcaDto);
        });
        return marcas;
    }

    @Override
    public List<CategoriaListDto> getAllCategories() {
        List<CategoriaListDto> categorias = new ArrayList<CategoriaListDto>();
        Iterable<Categoria> iterable = categoriaRepository.findAll();
        iterable.forEach( categoria -> {
            CategoriaListDto categoriaListDto = new CategoriaListDto(categoria.getIdCategoria(), categoria.getNombre());
            categorias.add(categoriaListDto);
        });
        return categorias;
    }

    @Override
    public List<ProductoTiendaDto> listProducts() {
        List<ProductoTiendaDto> products = new ArrayList<ProductoTiendaDto>();
        Iterable<Producto> iterable = productoRepository.findAll();
        iterable.forEach(producto -> {
            ProductoTiendaDto productoTiendaDto = new ProductoTiendaDto(
                    producto.getIdPro(),
                    producto.getUrlImg(),
                    producto.getMarca().getNombre(),
                    producto.getCategoria().getNombre(),
                    producto.getNombre(),
                    producto.getStock(),
                    producto.getPrecio()
            );
            products.add(productoTiendaDto);
        });
        return products;
    }
}
