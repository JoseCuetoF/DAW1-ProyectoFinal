package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceVentaService;

import java.util.List;

@Controller
@RequestMapping("/maintenanceVenta")
public class MaintenanceVentaController {


    @Autowired
    MaintenanceVentaService maintenanceVentaService;

    // Lista
    @GetMapping("/start")
    public String start(Model model) {
        List<VentaDto> ventas =maintenanceVentaService.findAllVentas();

        model.addAttribute("ventas",ventas);
        return "maintenance-ventas";
    }

    //Detalles

    @GetMapping("/detailVenta/{id}")
    public String detailVenta(@PathVariable Integer id, Model model) {
        VentaDto ventaDto = maintenanceVentaService.findVentaById(id);
        model.addAttribute("ventaDto",ventaDto);
        return "maintenance-ventas";
    }

    //Editar

    @GetMapping("/editVenta/{id}")
    public String editVenta(@PathVariable("id") int id, Model model) {
        VentaDto ventaDto = maintenanceVentaService.findVentaById(id);
        if(ventaDto == null) {
            return "redirect:maintenanceVenta/start";
        }
        model.addAttribute("ventaDto",ventaDto);
        return "maintenance-ventas-edit";
    }

    @PostMapping("/editVenta")
    public String editVenta(@ModelAttribute VentaDto ventaDto) {
        maintenanceVentaService.updateVenta(ventaDto);
        return "redirect:/maintenanceVenta/start";
    }

    //Eliminar
    @GetMapping("/deleteVenta/{id}")
    public String deleteVenta(@PathVariable("id") int id) {
        maintenanceVentaService.deleteVenta(id);
        return "redirect:/maintenanceVenta/start";
    }




}
