package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.model.AreaEntity;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
}
