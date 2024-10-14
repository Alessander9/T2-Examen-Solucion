package pe.com.cibertec.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity obtenerEmpleadoPorDni(String dni) {
        return empleadoRepository.findById(dni).orElse(null);
    }

    @Override
    public void crearEmpleado(EmpleadoEntity empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void actualizarEmpleado(EmpleadoEntity empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
}
