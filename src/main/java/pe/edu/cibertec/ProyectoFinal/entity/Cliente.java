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
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCli;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Integer telefono;
    private Integer dni;
    private String correo;
    private String password;
    private Date fechaRegistro;

    //bi-directional many-to-one association to Carrito
    @OneToMany(mappedBy="cliente")
    private List<Carrito> carritos;

    //bi-directional many-to-one association to Venta
    @OneToMany(mappedBy="cliente")
    private List<Venta> ventas;


}
