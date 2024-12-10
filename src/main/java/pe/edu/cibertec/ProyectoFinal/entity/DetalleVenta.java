package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalleventa")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    //private Integer idVenta;
    //private Integer idProducto;
    private Integer Cantidad;
    private Double  Total;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
