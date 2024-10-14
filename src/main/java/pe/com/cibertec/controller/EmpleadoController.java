package pe.com.cibertec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;

    // Listar todos los empleados
    @GetMapping("/empleado")
    public String listarEmpleados(Model model) {
        List<EmpleadoEntity> listaEmpleados = empleadoService.listarEmpleados();
        model.addAttribute("listaEmp", listaEmpleados);
        return "lista_empleados"; // Vista donde se mostrará la lista de empleados
    }

    // Buscar un empleado por DNI
    @GetMapping("/buscar/{dni}")
    public String buscarEmpleadoPorDni(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        model.addAttribute("empleado", empleado);
        return "detalle_empleado"; // Vista donde se mostrará el detalle del empleado
    }

    // Mostrar formulario de registro de empleado
    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        return "registrar_empleado"; // Vista con el formulario de registro
    }

    // Crear un nuevo empleado
    @PostMapping("/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleadoService.crearEmpleado(empleado);
        return "redirect:/empleado/"; // Redirige a la lista de empleados después de crear
    }

    // Mostrar formulario de actualización de empleado
    @GetMapping("/actualizar/{dni}")
    public String mostrarFormularioActualizar(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        model.addAttribute("empleado", empleado);
        return "actualizar_empleado"; // Vista con el formulario de actualización
    }

    // Actualizar empleado
    @PostMapping("/actualizar/{dni}")
    public String actualizarEmpleado(@PathVariable("dni") String dni, @ModelAttribute("empleado") EmpleadoEntity empleadoActualizado) {
        empleadoService.actualizarEmpleado(empleadoActualizado);
        return "redirect:/empleado/"; // Redirige a la lista de empleados después de actualizar
    }

    // Eliminar un empleado por DNI
    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empleado/"; // Redirige a la lista de empleados después de eliminar
    }
}
