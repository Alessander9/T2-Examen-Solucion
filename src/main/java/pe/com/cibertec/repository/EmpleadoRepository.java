package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.model.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
    EmpleadoEntity findByDniEmpleado(String dniEmpleado);
}
