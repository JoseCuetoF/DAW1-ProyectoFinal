package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {

    @Id
    private String idDistrito;
    private String descripcion;

}
