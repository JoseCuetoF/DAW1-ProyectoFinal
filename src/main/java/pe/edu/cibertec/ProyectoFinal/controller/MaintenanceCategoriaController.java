package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinal.dto.CategoriaDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceCategoriaService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceCategoriaController {


    @Autowired
    MaintenanceCategoriaService maintenanceCategoriaService;

    @GetMapping("/start")
    public String star(Model model) {
        List<CategoriaDto> categorias = maintenanceCategoriaService.getAllCategorias();
        model.addAttribute("categorias", categorias);
        return "maintenance-categoria";
    }


    //Eliminar
    @GetMapping("/deleteCategory/{id}")
    public String deleteVenta(@PathVariable("id") int id) {
        maintenanceCategoriaService.deleteCategory(id);
        return "redirect:/maintenance/start";
    }


}
