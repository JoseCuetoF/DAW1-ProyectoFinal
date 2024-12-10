package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPro;

    //private Integer idMarca;
    //private Integer idCategoria;

    private String nombre;
    private String detalles;
    private String urlImg;
    private Date fechaRegistro;
    private Integer stock;
    private Double precio;
    private Integer activo;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    //------
    @OneToMany
    private List<DetalleVenta> detalleVentas;

}
