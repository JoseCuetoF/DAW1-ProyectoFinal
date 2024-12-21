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
    public String start(Model model) throws Exception {

        List<ProductoDto> products = maintenanceProductoService.findAllProducts();

        model.addAttribute("products", products);
        return "maintenance-products";

    }

    // DETALLES
    @GetMapping("/detailUser/{id}")
    public String detailProduct(@PathVariable Integer id, Model model)throws Exception {

        ProductoDetailDto productoDetailDto = maintenanceProductoService.findProductById(id);
        model.addAttribute("productoDetailDto", productoDetailDto);
        return "maintenance-products-detail";
    }

        //AGREGAR
        @GetMapping("/addProduct")
        public String addProduct(Model model)throws Exception  {

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
            return "maintenance-products-add";
        }

    @PostMapping("/addProductConfirm")
    public String addProductConfirm(@ModelAttribute ProductoCreateDto productoCreateDto) throws Exception {

        maintenanceProductoService.insertProduct(productoCreateDto);
        return "redirect:/maintenanceProducts/start";
    }

    @GetMapping("/editProduct/{idPro}")
    public String editProductForm(@PathVariable("idPro") int id, Model model) throws Exception {

        List<MarcaDto> marcas = maintenanceProductoService.getAllBrands();
        List<CategoriaListDto> categorias = maintenanceProductoService.getAllCategories();

        ProductoDetailDto productoDetailDto = maintenanceProductoService.findProductById(id);
        if (productoDetailDto == null) {
            return "redirect:/maintenanceProducts/start";
        }

        model.addAttribute("marcas", marcas);
        model.addAttribute("categorias", categorias);
        model.addAttribute("productoDetailDto", productoDetailDto);
        return "maintenance-producto-edit";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute ProductoDetailDto productoDetailDto)throws Exception  {

        System.out.println("Producto ID: " + productoDetailDto.idPro());

        maintenanceProductoService.updateProduct(productoDetailDto);
        return "redirect:/maintenanceProducts/start";
    }

    // ELIMINAR
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) throws Exception {
        maintenanceProductoService.deleteProduct(id); // Llama al servicio para eliminar el producto
        return "redirect:/maintenanceProducts/start"; // Redirige al listado después de eliminar
    }

}
