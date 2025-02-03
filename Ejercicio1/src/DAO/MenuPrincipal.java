package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;




public class MenuPrincipal {

	public static void main(String[] args) {
		try (Connection connection = DatabaseConnection.getConnection()) {
            MultaDAO multaDAO = new MultaDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;
		
		
		do {
			
			System.out.println("\n--- Menú Principal ---");
			System.out.println("1) Consultar Multa");
            System.out.println("2) Añadir Multa");
            System.out.println("3) Modificar Multa");
            System.out.println("4) Borrar Multa");
            System.out.println("5) Listar Multas");
            System.out.println("0) Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
			
            
            switch (opcion) {
            
            case 1: // Consultar Asignatura
                System.out.print("Ingrese el ID de la Multa: ");
                int codMulta = scanner.nextInt();
                Multa multa = multaDAO.getMultaByCodigo(codMulta);
                if (multa != null) {
                    System.out.println("Multa encontrada: " + multa.toString());
                } else {
                    System.out.println("Multa no encontrada.");
                }
                break;
            
            case 2:
            	
            	System.out.println("Ingrese el código de la multa: ");
            	int nuevoCodigoMulta = scanner.nextInt();
            	scanner.nextLine();

            	System.out.println("Ingrese la descripción de la multa: ");
            	String nuevaDescripcion = scanner.nextLine();
            	
            	// si me da tiempo con el resto del examen hago lo de null.
            	System.out.println("Ingrese el código de la persona multada:  "); 
            	int nuevoCodPerMult = scanner.nextInt();
            	scanner.nextLine();
            	
            	// si me da tiempo con el resto del examen hago lo de null.
            	System.out.println("Ingrese el codigo del agente: ");
            	int nuevoCodAgente = scanner.nextInt();
            	scanner.nextLine();
            	
            	System.out.println("Ingrese importe de la sanción: ");
            	int nuevoImporteSancion = scanner.nextInt();
            	scanner.nextLine();
            	
            	// si me da tiempo con el resto del examen hago lo de null.
            	System.out.println("Ingrese los puntos de la sanción: ");
            	int nuevoPuntosSancion = scanner.nextInt();
            	scanner.nextLine();
            	
            	System.out.println("Ingrese la fecha de la multa (YYYY-MM-DD): ");
            	String nuevafecha = scanner.nextLine();
                Date nuevaFechaMulta = Date.valueOf(nuevafecha);  
                
                Multa nuevaMulta = new Multa(nuevoCodigoMulta, nuevaDescripcion, nuevoCodPerMult, nuevoCodAgente, nuevoImporteSancion, nuevoPuntosSancion, nuevaFechaMulta);
            	multaDAO.addMulta(nuevaMulta);
            	
            	System.out.println("Multa añadida.");
            	break;
            	
            case 3: // Modificar Multa
                System.out.print("Ingrese ID de la multa a modificar: ");
                int modificarMultaID = scanner.nextInt();
                scanner.nextLine();
                Multa multaAModificar = multaDAO.getMultaByCodigo(modificarMultaID);
                if (multaAModificar != null) {
                    System.out.print("Ingrese nueva descripción (actual: " + multaAModificar.getDescripcion() + "): ");
                    multaAModificar.setDescripcion(scanner.nextLine());
                    System.out.print("Ingresa el nuevo importe de la sanción (actual: " + multaAModificar.getImporteSancion() + "): ");
                    multaAModificar.setImporteSancion(scanner.nextInt());
                    scanner.nextLine();
                    
                    System.out.println("Multa actualizada.");
                } else {
                    System.out.println("Multa no encontrada.");
                }
                break;
                
            case 4: // Borrar Multa
                System.out.print("Ingrese ID de la multa a borrar: ");
                int borrarMultaID = scanner.nextInt();
                multaDAO.deleteMulta(borrarMultaID);
                System.out.println("Multa eliminada.");
                break;

            case 5: // Listar Asignaturas
                List<Multa> listaMultas = multaDAO.getAllMultas();
                System.out.println("\nLista de Multas:");
                listaMultas.forEach(a -> System.out.println(a.getCodMulta() + " - " + a.getDescripcion()));
                break;
            	
                
            case 0:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción no válida.");
                scanner.close();
                break;
            }
            
            
		} while (opcion != 0);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
