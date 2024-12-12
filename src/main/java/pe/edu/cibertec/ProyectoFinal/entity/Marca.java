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
    @JoinColumn(name="idmarca")
    private Integer idMarca;
    private String nombre;
    private int activo;
    private Date fechaRegistro;

    //bi-directional many-to-one association to Producto
    @OneToMany(mappedBy="marca")
    private List<Producto> productos;

}
