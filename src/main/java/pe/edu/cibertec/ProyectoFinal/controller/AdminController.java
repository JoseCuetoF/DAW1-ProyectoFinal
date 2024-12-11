package pe.edu.cibertec.ProyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.ProyectoFinal.dto.UserLoginDto;
import pe.edu.cibertec.ProyectoFinal.service.MaintenanceUsuarioService;

@Controller
public class AdminController {

    @Autowired
    MaintenanceUsuarioService maintenanceUsuarioService;

    // Método para mostrar el formulario de login
    @GetMapping("/loginAdmin")
    public String loginAdmin(Model model) {

        UserLoginDto userLoginDto = new UserLoginDto("","");
        model.addAttribute("userLoginDto", userLoginDto);

        return "login-admin";

    }

    // Método para procesar el login
    @PostMapping("/loginAdminSuccessfully")
    public String loginAdminSuccessfully(@ModelAttribute UserLoginDto userLoginDto) {

        // Validar el login usando el servicio
        boolean loginSuccess = maintenanceUsuarioService.loginUser(userLoginDto.correo(), userLoginDto.password());

        if (loginSuccess) {

            return "redirect:/maintenanceUsers/start";

        } else {

            return "redirect:/loginAdmin?error=true";

        }
    }

    @GetMapping("/admin")
    public String showAdminPanel() {
        return "maintenance";
    }
}