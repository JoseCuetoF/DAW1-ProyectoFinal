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
public class Venta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idVenta;
    //private Integer idCliente;
    private Integer cantidadProducto;
    private Double montoTotal;
    private String contacto;
    private Integer idDistrito;
    private Integer telefono;
    private String direccion;
    private String idTransaccion;
    private Date fechaVenta;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    //------
    @OneToMany
    private List<Venta> ventas;
}
