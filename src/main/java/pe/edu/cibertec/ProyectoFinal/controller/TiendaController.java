package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinal.dto.ProductoTiendaDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceProductoService;

import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    MaintenanceProductoService maintenanceProductoService;

    //Listado
    @GetMapping("/start")
    public String start(Model model) {

        List<ProductoTiendaDto> products = maintenanceProductoService.listProducts();
        model.addAttribute("products", products);
        return "tienda";

    }
    //Listado
    @GetMapping("/carrito")
    public String carrito(Model model) {

        List<ProductoTiendaDto> products = maintenanceProductoService.listProducts();
        model.addAttribute("products", products);
        return "carrito";

    }
}
