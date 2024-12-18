package pe.edu.cibertec.ProyectoFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/maintenance/loginAdmin").permitAll()
                        .requestMatchers("/maintenanceProducts/start").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )

                // redireccionar a una pagina de error en caso no tenga permisos
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler((request,
                                              response,
                                              accessDeniedException) -> {
                            // redirigi  a pagina restricted  si no esta autorizado
                            response.sendRedirect("/maintenanceProducts/restricted");
                        })
                )

                // configurar formulario de inicio de sesion
                .formLogin(form -> form
                        .loginPage("/maintenance/loginAdmin")
                        .failureUrl("/maintenance/loginAdmin?error=true") // Redirige si falla el login
                        .defaultSuccessUrl("/maintenanceProducts/start", false)
                        .permitAll()
                )

                //configurar salida
                .logout(logout-> logout
                        .logoutUrl("/maintenanceProducts/logout")
                        .logoutSuccessUrl("/maintenanceProducts/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public UserDetailsService userDetailsService(){

        return username-> User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
    }

}