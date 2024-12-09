package pe.edu.cibertec.ProyectoFinal.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {


    @Value("${DB_BdPetShop_URL}")
    private String dbBdPetShopUrl;
    @Value("${DB_BdPetShop_USER}")
    private String dbBdPetShopUser;
    @Value("${DB_BdPetShop_PASS}")
    private String dbBdPetShopPass;
    @Value("${DB_BdPetShop_DRIVER}")
    private String dbBdPetShopDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD

         */

        config.setJdbcUrl(dbBdPetShopUrl);
        config.setUsername(dbBdPetShopUser);
        config.setPassword(dbBdPetShopPass);
        config.setDriverClassName(dbBdPetShopDriver);

        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.

         */

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);
    }
}