package pe.com.cibertec.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.AreaEntity;
import pe.com.cibertec.repository.AreaRepository;
import pe.com.cibertec.service.AreaService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaEntity> listarAreas() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity obtenerAreaPorId(Integer id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearArea(AreaEntity area) {
        areaRepository.save(area);
    }

    @Override
    public void actualizarArea(AreaEntity area) {
        areaRepository.save(area);
    }

    @Override
    public void eliminarArea(Integer id) {
        areaRepository.deleteById(id);
    }
}
