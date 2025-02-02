package practicaCasa;

import java.util.List;
import java.util.Scanner;

import practica5.DAO.Empleado;
import practica5.DAO.EmpleadoDAO;
import practica5.DAO.EmpleadoDAOImpl;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        AlumnoDAO alumnoDAO = new AlumnoDAOImpl();

        int opcion;
        do {
            System.out.println("\nGESTIÓN DE Alumnos - MongoDB");
            System.out.println("1. Añadir Alumno");
            System.out.println("2. Mostrar Alumno por nombre");
            System.out.println("3. Mostrar Todos los Alumnos");
            System.out.println("4. Modificar nota de Alumno");
            System.out.println("5. Eliminar Alumno por nombre");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
            
            
            
            case 1:
            	System.out.println("\n=== AÑADIR ALUMNO ===");
            	Alumno nuevo = new Alumno();
            	
            	System.out.println("Introduce un nombre para el nuevo alumno: ");
            	nuevo.setNombre(sc.nextLine());
            	
            	System.out.println("Introduce un teléfono para el alumno: ");
            	nuevo.setTelefono(sc.nextLine());
            	
            	System.out.println("Introduce el curso del nuevo alumno: ");
            	nuevo.setCurso(sc.nextLine());
            	
            	System.out.println("Introduce la nota del alumno: ");
            	nuevo.setNota(Integer.parseInt(sc.nextLine()));
            	
            	System.out.println("Introduce la edad del alumno: ");
            	nuevo.setEdad(Integer.parseInt(sc.nextLine()));
            	
            	System.out.println("Introduce la población del nuevo alumno: ");
            	nuevo.setPoblacion(sc.nextLine());
            	
            	boolean creado = alumnoDAO.insertarAlumno(nuevo);
                if (creado) {
                    System.out.println("Alumno añadido correctamente.");
                } else {
                    System.out.println("No se pudo añadir el Alumno.");
                }
                break;
                
                
            case 2:
                System.out.println("\n=== MOSTRAR ALUMNO POR NOTA ===");
                System.out.print("Ingrese el nombre: ");
                String nombreBusqueda = sc.nextLine();
                Alumno encontrado = alumnoDAO.buscarPorNombre(nombreBusqueda);
                if (encontrado != null) {
                    System.out.println("\nAlumno encontrado: " + encontrado + "\n");
                } else {
                    System.out.println("No existe un Alumno con ese NIF.");
                }
                break;
 
            case 3:
                System.out.println("\n=== MOSTRAR TODOS LOS ALUMNOS ===");
                List<Alumno> lista = alumnoDAO.buscarTodos();
                if (lista.isEmpty()) {
                    System.out.println("No hay Alumnos en la base de datos.");
                } else {
                    for (Alumno a : lista) {
                        System.out.println(a +"\n---------------------------");
                    }
                }
                break;
                
            case 4:
                System.out.println("\n=== MODIFICAR NOTA DEL ALUMNO ===");
                System.out.print("Ingrese el nombre: ");
                String nombreMod = sc.nextLine();
                System.out.print("Ingrese el nuevo salario: ");
                int nuevaNota = Integer.parseInt(sc.nextLine());
                boolean modificado = alumnoDAO.actualizarNota(nombreMod, nuevaNota);
                if (modificado) {
                    System.out.println("Nota actualizada correctamente.");
                } else {
                    System.out.println("No se pudo actualizar la nota.");
                }
                break;
                
            case 5: 
                System.out.println("\n=== ELIMINAR EMPLEADO POR NOMBRE ===");
                System.out.print("Ingrese el nombre: ");
                String nombreEliminar = sc.nextLine();
                boolean eliminado = alumnoDAO.eliminarAlumno(nombreEliminar);
                if (eliminado) {
                    System.out.println("Alumno eliminado correctamente.");
                } else {
                    System.out.println("No se encontró un alumno con ese nombre para eliminar.");
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

	}

}
