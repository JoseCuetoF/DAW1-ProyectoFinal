package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;
    private String nombre;
    private int activo;
    private Date fechaRegistro;

    @OneToMany
    private List<Producto> productos;

}
