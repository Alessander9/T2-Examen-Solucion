package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.EmpleadoEntity;

public interface EmpleadoService {
    List<EmpleadoEntity> listarEmpleados();
    EmpleadoEntity obtenerEmpleadoPorDni(String dni);
    void crearEmpleado(EmpleadoEntity empleado);
    void actualizarEmpleado(EmpleadoEntity empleado);
    void eliminarEmpleado(String dni);
}
