package DAO.Practica3;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            AsignaturaDAO asignaturaDAO = new AsignaturaDAOImpl(connection);
            ProfesorDAO profesorDAO = new ProfesorDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- Menú de Gestión ---");
                System.out.println("1) Consultar Asignatura");
                System.out.println("2) Añadir Asignatura");
                System.out.println("3) Modificar Asignatura");
                System.out.println("4) Borrar Asignatura");
                System.out.println("5) Listar Asignaturas");
                System.out.println("6) Consultar Profesor");
                System.out.println("7) Añadir Profesor");
                System.out.println("8) Modificar Profesor");
                System.out.println("9) Borrar Profesor");
                System.out.println("10) Listar Profesores");
                System.out.println("0) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1: // Consultar Asignatura
                        System.out.print("Ingrese el ID de la asignatura: ");
                        int asignaturaId = scanner.nextInt();
                        Asignatura asignatura = asignaturaDAO.getAsignaturaById(asignaturaId);
                        if (asignatura != null) {
                            System.out.println("Asignatura encontrada: " + asignatura.getNombre());
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 2: // Añadir Asignatura
                        System.out.print("Ingrese ID: ");
                        int nuevaAsignaturaId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String asignaturaNombre = scanner.nextLine();
                        System.out.print("Ingrese créditos: ");
                        double asignaturaCreditos = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Ingrese tipo: ");
                        String asignaturaTipo = scanner.nextLine();
                        System.out.print("Ingrese curso: ");
                        int asignaturaCurso = scanner.nextInt();
                        System.out.print("Ingrese cuatrimestre: ");
                        int asignaturaCuatrimestre = scanner.nextInt();
                        System.out.print("Ingrese ID del profesor (0 si no tiene): ");
                        int profesorId = scanner.nextInt();
                        System.out.print("Ingrese ID del grado: ");
                        int gradoId = scanner.nextInt();

                        Asignatura nuevaAsignatura = new Asignatura(nuevaAsignaturaId, asignaturaNombre, asignaturaCreditos, asignaturaTipo, asignaturaCurso, asignaturaCuatrimestre, profesorId != 0 ? profesorId : null, gradoId);
                        asignaturaDAO.addAsignatura(nuevaAsignatura);
                        System.out.println("Asignatura añadida.");
                        break;

                    case 3: // Modificar Asignatura
                        System.out.print("Ingrese ID de la asignatura a modificar: ");
                        int modificarAsignaturaId = scanner.nextInt();
                        scanner.nextLine();
                        Asignatura asignaturaParaModificar = asignaturaDAO.getAsignaturaById(modificarAsignaturaId);
                        if (asignaturaParaModificar != null) {
                            System.out.print("Ingrese nuevo nombre (actual: " + asignaturaParaModificar.getNombre() + "): ");
                            asignaturaParaModificar.setNombre(scanner.nextLine());
                            System.out.print("Ingrese nuevos créditos (actual: " + asignaturaParaModificar.getCreditos() + "): ");
                            asignaturaParaModificar.setCreditos(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.print("Ingrese nuevo tipo (actual: " + asignaturaParaModificar.getTipo() + "): ");
                            asignaturaParaModificar.setTipo(scanner.nextLine());
                            asignaturaDAO.updateAsignatura(asignaturaParaModificar);
                            System.out.println("Asignatura actualizada.");
                        } else {
                            System.out.println("Asignatura no encontrada.");
                        }
                        break;

                    case 4: // Borrar Asignatura
                        System.out.print("Ingrese ID de la asignatura a borrar: ");
                        int borrarAsignaturaId = scanner.nextInt();
                        asignaturaDAO.deleteAsignatura(borrarAsignaturaId);
                        System.out.println("Asignatura eliminada.");
                        break;

                    case 5: // Listar Asignaturas
                        List<Asignatura> listaAsignaturas = asignaturaDAO.getAllAsignaturas();
                        System.out.println("\nLista de asignaturas:");
                        listaAsignaturas.forEach(a -> System.out.println(a.getId() + " - " + a.getNombre()));
                        break;

                    case 6: // Consultar Profesor
                        System.out.print("Ingrese el ID del profesor: ");
                        int consultarProfesorId = scanner.nextInt();
                        Profesor profesor = profesorDAO.getProfesorById(consultarProfesorId);
                        if (profesor != null) {
                            System.out.println("Profesor encontrado: ID " + profesor.getIdProfesor() +
                                    ", Departamento " + profesor.getIdDepartamento());
                        } else {
                            System.out.println("Profesor no encontrado.");
                        }
                        break;

                    case 7: // Añadir Profesor
                        System.out.print("Ingrese ID del profesor: ");
                        int nuevoProfesorId = scanner.nextInt();
                        System.out.print("Ingrese ID del departamento: ");
                        int profesorDepartamentoId = scanner.nextInt();
                        profesorDAO.addProfesor(new Profesor(nuevoProfesorId, profesorDepartamentoId));
                        System.out.println("Profesor añadido.");
                        break;

                    case 8: // Modificar Profesor
                        System.out.print("Ingrese ID del profesor a modificar: ");
                        int modificarProfesorId = scanner.nextInt();
                        Profesor profesorParaModificar = profesorDAO.getProfesorById(modificarProfesorId);
                        if (profesorParaModificar != null) {
                            System.out.print("Ingrese nuevo ID del departamento (actual: " + profesorParaModificar.getIdDepartamento() + "): ");
                            profesorParaModificar.setIdDepartamento(scanner.nextInt());
                            profesorDAO.updateProfesor(profesorParaModificar);
                            System.out.println("Profesor actualizado.");
                        } else {
                            System.out.println("Profesor no encontrado.");
                        }
                        break;

                    case 9: // Borrar Profesor
                        System.out.print("Ingrese ID del profesor a borrar: ");
                        int borrarProfesorId = scanner.nextInt();
                        profesorDAO.deleteProfesor(borrarProfesorId);
                        System.out.println("Profesor eliminado.");
                        break;

                    case 10: // Listar Profesores
                        List<Profesor> listaProfesores = profesorDAO.getAllProfesores();
                        System.out.println("\nLista de profesores:");
                        listaProfesores.forEach(p -> System.out.println("ID: " + p.getIdProfesor() +
                                ", Departamento: " + p.getIdDepartamento()));
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
        } catch (Exception e) {
            e.printStackTrace();     
        }
    }
}
