package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nombre;
    private Integer activo;
    private Date fechaRegistro;

    //bi-directional many-to-one association to Producto
    @OneToMany(mappedBy="categoria")
    private List<Producto> productos;




}
