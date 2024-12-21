package pe.edu.cibertec.ProyectoFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinal.dto.DistritoDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceDistritoService;

import java.util.List;

@Controller
@RequestMapping("maintenanceDistrito")
public class MaintenanceDistritoController {

    @Autowired
    MaintenanceDistritoService maintenanceDistritoService;

    @GetMapping("/start")
    public String start(Model model)throws Exception {
        List<DistritoDto> distritos = maintenanceDistritoService.getAllDistrito();
        model.addAttribute("distritos", distritos);
        return "maintenance-distrito";
    }
}
