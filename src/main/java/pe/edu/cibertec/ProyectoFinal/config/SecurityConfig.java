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
                        // Permitir acceso a recursos estáticos
                        .requestMatchers("/img/", "/css/", "/js/**").permitAll()
                        // Permitir acceso a la página de login
                        .requestMatchers("/manage/login").permitAll()
                        // Restringir acceso a rutas específicas
                        .requestMatchers("/maintenanceProducts/start").hasAnyRole("ADMIN")
                        .requestMatchers("/maintenance/start").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )

                // redireccionar a una pagina de error en caso no tenga permisos
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler((request,
                                              response,
                                              accessDeniedException) -> {
                            // redirigr a pagina restricted  si no esta autorizado
                            response.sendRedirect("/manage/restricted");
                        })
                )

                // configurar formulario de inicio de sesion
                .formLogin(form -> form
                        .loginPage("/manage/login")
                        .defaultSuccessUrl("/maintenanceProducts/start", false)
                        .permitAll()
                )

                //configurar salida
                .logout(logout-> logout
                        .logoutUrl("/manage/logout")
                        .logoutSuccessUrl("/manage/login?logout")
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
                .username("Admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();
    }

}