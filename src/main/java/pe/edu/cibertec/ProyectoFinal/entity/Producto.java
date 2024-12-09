package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPro;
    private Integer idMarca;
    private Integer idCategoria;
    private String nombre;
    private String detalles;
    private String urlImg;
    private Date fechaRegistro;
    private int stock;
    private Double precio;
    private int activo;






}
