package practica5.DAO;
import java.util.List;
import java.util.Scanner;

import practica5.DAO.EmpleadoDAOImpl;
import practica5.DAO.EmpleadoDAO;
import practica5.DAO.Empleado;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        int opcion;
        do {
            System.out.println("\nGESTIÓN DE EMPLEADOS - MongoDB");
            System.out.println("1. Añadir Empleado");
            System.out.println("2. Mostrar Empleado por NIF");
            System.out.println("3. Mostrar Todos los Empleados");
            System.out.println("4. Modificar Salario de Empleado");
            System.out.println("5. Eliminar Empleado por NIF");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
            
            	// Añadir empleado
                case 1:
                    System.out.println("\n=== AÑADIR EMPLEADO ===");
                    Empleado nuevo = new Empleado();

                    System.out.print("Número de Empleado (NumEmp): ");
                    nuevo.setNumEmp(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nombre: ");
                    nuevo.setNombre(sc.nextLine());

                    System.out.print("Departamento (dep): ");
                    nuevo.setDep(Integer.parseInt(sc.nextLine()));

                    System.out.print("Salario: ");
                    nuevo.setSalario(Double.parseDouble(sc.nextLine()));

                    System.out.print("Fecha de Alta (dd/mm/aaaa): ");
                    nuevo.setFechaAlta(sc.nextLine());

                    System.out.print("Oficio (opcional, puede dejarlo vacío): ");
                    String oficio = sc.nextLine();
                    nuevo.setOficio(oficio.isEmpty() ? null : oficio);

                    System.out.print("Comisión (opcional, 0 si no aplica): ");
                    int comision = Integer.parseInt(sc.nextLine());
                    nuevo.setComision(comision);

                    System.out.print("NIF: ");
                    nuevo.setNif(sc.nextLine());

                    boolean creado = empleadoDAO.insertarEmpleado(nuevo);
                    if (creado) {
                        System.out.println("Empleado añadido correctamente.");
                    } else {
                        System.out.println("No se pudo añadir el empleado.");
                    }
                    break;

                    // Mostrar empleado por NIF
                case 2:
                    System.out.println("\n=== MOSTRAR EMPLEADO POR NIF ===");
                    System.out.print("Ingrese el NIF: ");
                    String nifBusqueda = sc.nextLine();
                    Empleado encontrado = empleadoDAO.buscarEmpleadoPorNIF(nifBusqueda);
                    if (encontrado != null) {
                        System.out.println("\nEmpleado encontrado: " + encontrado + "\n");
                    } else {
                        System.out.println("No existe un empleado con ese NIF.");
                    }
                    break;

                    // Mostrar todos los empleados
                case 3:
                    System.out.println("\n=== MOSTRAR TODOS LOS EMPLEADOS ===");
                    List<Empleado> lista = empleadoDAO.buscarTodosLosEmpleados();
                    if (lista.isEmpty()) {
                        System.out.println("No hay empleados en la base de datos.");
                    } else {
                        for (Empleado emp : lista) {
                            System.out.println(emp +"\n---------------------------");
                        }
                    }
                    break;
                    
                    // Modificar salario empleado
                case 4:
                    System.out.println("\n=== MODIFICAR SALARIO DE EMPLEADO ===");
                    System.out.print("Ingrese el NIF: ");
                    String nifMod = sc.nextLine();
                    System.out.print("Ingrese el nuevo salario: ");
                    double nuevoSalario = Double.parseDouble(sc.nextLine());
                    boolean modificado = empleadoDAO.actualizarSalarioEmpleado(nifMod, nuevoSalario);
                    if (modificado) {
                        System.out.println("Salario actualizado correctamente.");
                    } else {
                        System.out.println("No se pudo actualizar el salario.");
                    }
                    break;
                    
                    // Eliminar empleado.
                case 5: 
                    System.out.println("\n=== ELIMINAR EMPLEADO POR NIF ===");
                    System.out.print("Ingrese el NIF: ");
                    String nifEliminar = sc.nextLine();
                    boolean eliminado = empleadoDAO.eliminarEmpleadoPorNIF(nifEliminar);
                    if (eliminado) {
                        System.out.println("Empleado eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un empleado con ese NIF para eliminar.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
        // para cerrar conexion::
        // MongoDBConnection.getInstancia().close();
    }
}