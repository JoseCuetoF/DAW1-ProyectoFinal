package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintenanceUsers")
public class UsuarioController {

    @Autowired
    MaintenanceUsuarioService maintenanceUsuarioService;

    @GetMapping("/start")
    public String start(Model model) {

        List<UsuarioDetailDto> users = maintenanceUsuarioService.findAllUsers();
        model.addAttribute("users", users);
        return "maintenance-users";
    }

    // DETALLES
    @GetMapping("/detailUser/{id}")
    public String detailUser(@PathVariable Integer id, Model model){

        UsuarioDetailDto usuarioDetailDto = maintenanceUsuarioService.findUserById(id);
        model.addAttribute("usuarioDetailDto", usuarioDetailDto);
        return "maintenance-user-detail";
    }

    //AGREGAR
    @GetMapping("/addUser")
    public String addUser(Model model) {
        UsuarioCreateDto usuarioCreateDto = new UsuarioCreateDto(
                "",
                "",
                "",
                 new Date()
        );

        model.addAttribute("usuarioDetailDto", usuarioCreateDto);
        return "maintenance-user-add";
    }

    @PostMapping("/addUserConfirm")
    public String addUserConfirm(@ModelAttribute UsuarioCreateDto usuarioCreateDto) {
        maintenanceUsuarioService.insertUser(usuarioCreateDto);
        return "redirect:/maintenanceUsers/start";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        UsuarioDetailDto usuarioDetailDto = maintenanceUsuarioService.findUserById(id);
        if (usuarioDetailDto == null) {
            return "redirect:/maintenanceUsers/start";
        }
        model.addAttribute("usuarioDetailDto", usuarioDetailDto);
        return "maintenance-user-edit";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute UsuarioDetailDto usuarioDetailDto) {
        maintenanceUsuarioService.updateUser(usuarioDetailDto);
        return "redirect:/maintenanceUsers/start";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        maintenanceUsuarioService.deleteUser(id);
        return "redirect:/maintenanceUsers/start";
    }
}

