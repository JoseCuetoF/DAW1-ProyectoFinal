package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.dto.VentaDetailDto;
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
    public String start(Model model) throws Exception {
        List<VentaDto> ventas =maintenanceVentaService.findAllVentas();

        model.addAttribute("ventas",ventas);
        return "maintenance-ventas";
    }

    //Detalles

    @GetMapping("/detailVenta/{id}")
    public String detailVenta(@PathVariable Integer id, Model model) throws Exception  {
        VentaDetailDto ventaDetailDto = maintenanceVentaService.findVentaById(id);
        model.addAttribute("venta",ventaDetailDto);
        return "maintenance-venta-detail";
    }

    //Editar

    @GetMapping("/editVenta/{id}")
    public String editVenta(@PathVariable("id") int id, Model model) throws Exception {

        List<DistritoDto> distritos = maintenanceVentaService.findAllDistritos();

        VentaDetailDto ventaDetailDto = maintenanceVentaService.findVentaById(id);
        if(ventaDetailDto == null) {
            return "redirect:maintenanceVenta/start";
        }

        model.addAttribute("distritos",distritos);
        model.addAttribute("venta",ventaDetailDto);
        // Verificar que la fechaVenta esté correctamente configurada
        System.out.println("Fecha de Venta: " + ventaDetailDto.fechaVenta()); // Log para depuración

        return "maintenance-venta-edit";


    }

    @PostMapping("/editVenta")
    public String editVenta(@ModelAttribute VentaDetailDto ventaDetailDto)throws Exception  {
        maintenanceVentaService.updateVenta(ventaDetailDto);
        return "redirect:/maintenanceVenta/start";
    }

    //Eliminar
    @GetMapping("/deleteVenta/{id}")
    public String deleteVenta(@PathVariable("id") int id)throws Exception  {
        maintenanceVentaService.deleteVenta(id);
        return "redirect:/maintenanceVenta/start";
    }




}
