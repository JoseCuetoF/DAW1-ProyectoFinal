package pe.edu.cibertec.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.ProyectoFinal.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
}
