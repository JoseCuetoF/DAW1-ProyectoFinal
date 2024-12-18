package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinal.dto.UserLoginDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

@Controller
@RequestMapping("/manage")
public class AdminController {

    @Autowired
    MaintenanceUsuarioService maintenanceUsuarioService;

    @GetMapping("/restricted")
    public String restricted (Model model) {
        return "restricted";
    }

    // Método para mostrar el formulario de login
    @GetMapping("/login")
    public String login(Model model) {

        UserLoginDto userLoginDto = new UserLoginDto("","");
        model.addAttribute("userLoginDto", userLoginDto);

        return "login-admin";

    }

    @GetMapping("/dashboard")
    public String showAdminDashboard() {
        return "dashboard";
    }
}