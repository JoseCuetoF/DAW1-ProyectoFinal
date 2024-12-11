package pe.edu.cibertec.ProyectoFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinal.dto.*;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceProductoService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintenanceProducts")
public class ProductoController {

    @Autowired
    MaintenanceProductoService maintenanceProductoService;

    //Listado
    @GetMapping("/start")
    public String start(Model model) {

        List<ProductoDto> products = maintenanceProductoService.findAllProducts();
        model.addAttribute("products", products);
        return "maintenance-products";

    }

    // DETALLES
    @GetMapping("/detailUser/{id}")
    public String detailProduct(@PathVariable Integer id, Model model){

        ProductoDetailDto productoDetailDto = maintenanceProductoService.findProductById(id);
        model.addAttribute("productoDetailDto", productoDetailDto);
        return "maintenance-product-detail";
    }

    //AGREGAR
    @GetMapping("/addProduct")
    public String addProduct(Model model) {

        List<MarcaDto> marcas = maintenanceProductoService.getAllBrands();
        List<CategoriaListDto> categorias = maintenanceProductoService.getAllCategories();


        ProductoCreateDto productoCreateDto = new ProductoCreateDto(
                null,
                null,
                null,
                null,
                null,
                null,
                new Date(),
                null,
                null,
                null

        );

        model.addAttribute("marcas", marcas);
        model.addAttribute("categorias", categorias);
        model.addAttribute("productoCreateDto", productoCreateDto);
        return "maintenance-product-add";
    }

    @PostMapping("/addProductConfirm")
    public String addProductConfirm(@ModelAttribute ProductoCreateDto productoCreateDto) {

        maintenanceProductoService.insertProduct(productoCreateDto);
        return "redirect:/maintenanceProducts/start";
    }

    @GetMapping("/editProduct/{id}")
    public String editProductForm(@PathVariable("id") int id, Model model) {

        List<MarcaDto> marcas = maintenanceProductoService.getAllBrands();
        List<CategoriaListDto> categorias = maintenanceProductoService.getAllCategories();

        ProductoDetailDto productoDetailDto = maintenanceProductoService.findProductById(id);
        if (productoDetailDto == null) {
            return "redirect:/maintenanceUsers/start";
        }


        model.addAttribute("marcas", marcas);
        model.addAttribute("categorias", categorias);

        model.addAttribute("productoDetailDto", productoDetailDto);
        return "maintenance-user-edit";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute ProductoUpdateDto productoUpdateDto) {
        maintenanceProductoService.updateProduct(productoUpdateDto);
        return "redirect:/maintenanceUsers/start";
    }

}
