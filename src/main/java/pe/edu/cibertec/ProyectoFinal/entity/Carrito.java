package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCarrito;
    // private Integer idCliente;
    // private Integer idProducto;
    private Integer cantidad;


    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    //bi-directional many-to-one association to Producto
    @ManyToOne
    @JoinColumn(name="idProducto")
    private Producto producto;


}
