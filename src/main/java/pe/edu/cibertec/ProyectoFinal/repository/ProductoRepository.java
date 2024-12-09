package pe.edu.cibertec.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.ProyectoFinal.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
