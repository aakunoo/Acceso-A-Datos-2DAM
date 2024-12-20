package DAO.Practica3;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            AsignaturaDAO asignaturaDAO = new AsignaturaDAOImpl(connection);
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- Menú de Gestión de Asignaturas ---");
                System.out.println("1) Consultar Asignatura");
                System.out.println("2) Añadir Asignatura");
                System.out.println("3) Modificar Asignatura");
                System.out.println("4) Borrar Asignatura");
                System.out.println("5) Listar Asignaturas");
                System.out.println("0) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1: // Consultar
                        System.out.print("Ingrese el ID de la asignatura: ");
                        int id = sc.nextInt();
                        Asignatura asignatura = asignaturaDAO.getAsignaturaById(id);
                        if (asignatura != null) {
                            System.out.println("Asignatura encontrada: " + asignatura.getNombre());
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 2: // Añadir
                        System.out.print("Ingrese ID: ");
                        int newId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese créditos: ");
                        double creditos = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Ingrese tipo: ");
                        String tipo = sc.nextLine();
                        System.out.print("Ingrese curso: ");
                        int curso = sc.nextInt();
                        System.out.print("Ingrese cuatrimestre: ");
                        int cuatrimestre = sc.nextInt();
                        System.out.print("Ingrese ID del profesor (0 si no tiene): ");
                        int idProfesor = sc.nextInt();
                        System.out.print("Ingrese ID del grado: ");
                        int idGrado = sc.nextInt();

                        Asignatura newAsignatura = new Asignatura(newId, nombre, creditos, tipo, curso, cuatrimestre, idProfesor != 0 ? idProfesor : null, idGrado);
                        asignaturaDAO.addAsignatura(newAsignatura);
                        System.out.println("Asignatura añadida.");
                        break;

                    case 3: // Modificar
                        System.out.print("Ingrese ID de la asignatura a modificar: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        Asignatura updateAsignatura = asignaturaDAO.getAsignaturaById(updateId);
                        if (updateAsignatura != null) {
                            System.out.print("Ingrese nuevo nombre (actual: " + updateAsignatura.getNombre() + "): ");
                            updateAsignatura.setNombre(sc.nextLine());
                            System.out.print("Ingrese nuevos créditos (actual: " + updateAsignatura.getCreditos() + "): ");
                            updateAsignatura.setCreditos(sc.nextDouble());
                            sc.nextLine();
                            System.out.print("Ingrese nuevo tipo (actual: " + updateAsignatura.getTipo() + "): ");
                            updateAsignatura.setTipo(sc.nextLine());
                            asignaturaDAO.updateAsignatura(updateAsignatura);
                            System.out.println("Asignatura actualizada.");
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 4: // Borrar
                        System.out.print("Ingrese ID de la asignatura a borrar: ");
                        int deleteId = sc.nextInt();
                        asignaturaDAO.deleteAsignatura(deleteId);
                        System.out.println("Asignatura eliminada.");
                        break;

                    case 5: // Listar
                        List<Asignatura> asignaturas = asignaturaDAO.getAllAsignaturas();
                        System.out.println("\nLista de asignaturas:");
                        asignaturas.forEach(a -> System.out.println(a.getId() + " - " + a.getNombre()));
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
