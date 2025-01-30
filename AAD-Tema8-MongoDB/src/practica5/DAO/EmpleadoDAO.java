package practica5.DAO;

import java.util.List;

public interface EmpleadoDAO {

    boolean insertarEmpleado(Empleado empleado);
    Empleado buscarEmpleadoPorNIF(String nif);
    List<Empleado> buscarTodosLosEmpleados();
    boolean actualizarSalarioEmpleado(String nif, double nuevoSalario);
    boolean eliminarEmpleadoPorNIF(String nif);
    
}
