package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioCreateDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDetailDto;
import pe.edu.cibertec.ProyectoFinal.dto.UsuarioDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintenanceUsers")
public class UsuarioController {

    @Autowired
    MaintenanceUsuarioService maintenanceUsuarioService;

    @GetMapping("/start")
    public String start(Model model) throws Exception {

        List<UsuarioDto> users = maintenanceUsuarioService.findAllUsers();
        model.addAttribute("users", users);
        return "maintenance-users";
    }

    // DETALLES
    @GetMapping("/detailUser/{id}")
    public String detailUser(@PathVariable Integer id, Model model)throws Exception {

        UsuarioDetailDto usuarioDetailDto = maintenanceUsuarioService.findUserById(id);
        model.addAttribute("usuarioDetailDto", usuarioDetailDto);
        return "maintenance-user-detail";
    }

    //AGREGAR
    @GetMapping("/addUser")
    public String addUser(Model model) throws Exception {
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
    public String addUserConfirm(@ModelAttribute UsuarioCreateDto usuarioCreateDto) throws Exception {
        maintenanceUsuarioService.insertUser(usuarioCreateDto);
        return "redirect:/maintenanceUsers/start";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model)throws Exception  {
        UsuarioDetailDto usuarioDetailDto = maintenanceUsuarioService.findUserById(id);
        if (usuarioDetailDto == null) {
            return "redirect:/maintenanceUsers/start";
        }
        model.addAttribute("usuarioDetailDto", usuarioDetailDto);
        return "maintenance-user-edit";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute UsuarioDto usuarioDto)throws Exception  {
        maintenanceUsuarioService.updateUser(usuarioDto);
        return "redirect:/maintenanceUsers/start";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) throws Exception {
        maintenanceUsuarioService.deleteUser(id);
        return "redirect:/maintenanceUsers/start";
    }
}

