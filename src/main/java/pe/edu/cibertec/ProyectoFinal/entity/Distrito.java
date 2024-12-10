package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {

    @Id
    private String idDistrito;
    private String descripcion;

    //bi-directional many-to-one association to Venta
    @OneToMany(mappedBy="distrito")
    private List<Venta> ventas;

}
