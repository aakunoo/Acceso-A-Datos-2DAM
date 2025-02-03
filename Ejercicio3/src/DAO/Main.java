package DAO;

import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        GrupoDAO grupoDAO = new GrupoDAOImpl();

        int opcion;
        do {
        	
        	System.out.println("\nMenú");
            System.out.println("1. Añadir Grupo");
            System.out.println("2. Modificar Grupo");
            System.out.println("3. Borrar Grupo");
            System.out.println("4. Listar Grupos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
            
            case 1:
                System.out.println("\n=== AÑADIR GRUPO ===");
                Grupo nuevo = new Grupo();

                System.out.print("Nombre del grupo: ");
                nuevo.setGrupo(sc.nextLine());

                System.out.print("Género: ");
                nuevo.setGenero(sc.nextLine());

                System.out.print("Década: ");
                nuevo.setDecada(sc.nextLine());

//                System.out.print("Discos (separados por coma): ");
//                nuevo.setDiscos(sc.nextLine().split(", "));
//
//                System.out.print("Giras (separado por coma): ");
//                nuevo.setFechaAlta(sc.nextLine());


                boolean creado = grupoDAO.insertarGrupo(nuevo);
                if (creado) {
                    System.out.println("Empleado añadido correctamente.");
                } else {
                    System.out.println("No se pudo añadir el empleado.");
                }
                break;
            
            
            
            case 2:
            	System.out.println("\n=== MODIFICAR GENERO DEL GRUPO ===");
                System.out.print("Ingrese el nombre: ");
                String nombreMod = sc.nextLine();
                System.out.print("Ingrese el nuevo genero: ");
                String nuevoGenero = sc.nextLine();
                boolean modificado = grupoDAO.actualizarGrupo(nombreMod, nuevoGenero);
                if (modificado) {
                    System.out.println("Genero actualizado correctamente.");
                } else {
                    System.out.println("No se pudo actualizar el genero.");
                }
                break;
            case 3:
            	System.out.println("\n=== ELIMINAR GRUPO POR NOMBRE ===");
                System.out.print("Ingrese el nombre: ");
                String nombreEliminar = sc.nextLine();
                boolean eliminado = grupoDAO.eliminarGrupo(nombreEliminar);
                if (eliminado) {
                    System.out.println("Grupo eliminado correctamente.");
                } else {
                    System.out.println("No se encontró un grupo con ese nombre para eliminar.");
                }
                break;
            case 4:
            	
            	System.out.println("\n=== MOSTRAR TODOS LOS GRUPOS ===");
                List<Grupo> lista = grupoDAO.listarTodosGrupos();
                if (lista.isEmpty()) {
                    System.out.println("No hay Grupos en la base de datos.");
                } else {
                    for (Grupo g : lista) {
                        System.out.println(g +"\n---------------------------");
                    }
                }
                break;
        

        case 5:
            System.out.println("Saliendo del programa...");
            break;

        default:
            System.out.println("Opción inválida. Intente de nuevo.");
            break;
            }
        } while (opcion != 5);


	}

}
