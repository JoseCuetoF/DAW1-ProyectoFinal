package pe.edu.cibertec.ProyectoFinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer idCliente;
    private Integer idProducto;
    private Integer cantidad;
}
