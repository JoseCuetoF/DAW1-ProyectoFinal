package pe.edu.cibertec.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.ProyectoFinal.dto.CarritoDto;
import pe.edu.cibertec.ProyectoFinal.dto.ClienteDto;
import pe.edu.cibertec.ProyectoFinal.entity.Carrito;
import pe.edu.cibertec.ProyectoFinal.entity.Cliente;

import java.util.List;

public interface CarritoRepository extends CrudRepository<Carrito, Integer> {

}
