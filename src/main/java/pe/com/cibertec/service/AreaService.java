package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.AreaEntity;

public interface AreaService {

	List<AreaEntity> listarAreas();
    AreaEntity obtenerAreaPorId(Long id);
    void crearArea(AreaEntity area);
    void actualizarArea(AreaEntity area);
    void eliminarArea(Long id);
}
