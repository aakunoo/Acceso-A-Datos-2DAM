package Serializacion.Practica2Serializacion;

import java.io.*;
import java.util.Scanner;

public class GestionAlumnos {
	private static final String ruta = "alumnos.dat";
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		boolean continuar = true;

		while (continuar) {
			System.out.println("1. Crear Fichero\n" + "2. Añadir alumno\n" + "3. Listar alumnos\n" + "4. Borrar fichero\n" + "5. Salir de la aplicación.");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			try {
                switch (opcion) {
                	case 1:
                        crearFichero();
                        break;
                    case 2:
                        añadirAlumno();
                        break;
                    case 3:
                        listarAlumnos();
                        break;
                    case 4:
                        borrarFichero();
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Saliendo de la aplicación...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
		}
	}

	private static void crearFichero() {
		
		File file = new File("alumnos.dat");
        if (file.exists()) {
            System.out.println("El fichero ya existe.");
        } else {
            try {
                new ObjectOutputStream(new FileOutputStream(file)).close();
                System.out.println("Fichero creado.");
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }
	}

	private static void añadirAlumno() {
		 try {
			 
			 Scanner sc = new Scanner(System.in);
	            System.out.print("Introduce el DNI del alumno: ");
				String dni = sc.nextLine();
	            validarDNI(dni);

	            System.out.print("Introduce el nombre del alumno: ");
	            String nombre = sc.nextLine();

	            System.out.print("Introduce la nota de AD: ");
	            double notaAD = sc.nextDouble();
	            sc.nextLine();

	            Alumno alumno = new Alumno(dni, nombre, notaAD);

	            File file = new File("alumnos.dat");
	            FileOutputStream fos = new FileOutputStream(file, true);
	            ObjectOutputStream oos;
	            
	            if (file.length() == 0) {
	                oos = new ObjectOutputStream(fos); 
	            } else {
	                oos = new MiObjectOutputStream(fos); 
	            }

	            oos.writeObject(alumno);
	            System.out.println("Alumno añadido.");

	            oos.close();
	            fos.close();

		 	} catch (DNIException e) {
		        System.out.println("Error en el DNI: " + e.getMessage());
		    } catch (IOException e) {
		        System.out.println("Error al escribir en el archivo: " + e.getMessage());
		    }
		}

	private static void validarDNI(String dni) throws DNIException {
		if (dni.length() < 8) {
		    throw new DNIException(DNIException.LONGITUD_NO_CORRECTA);
		} else if (dni.length() > 9) {
		    throw new DNIException(DNIException.LONGITUD_NO_CORRECTA);
		}

        String numero = dni.substring(0, dni.length() - 1);
        String letra = dni.substring(dni.length() - 1);

        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new DNIException(DNIException.PARTE_NUMERICA_NO_CORRECTA);
        }

        if (!letra.matches("[A-Z]")) {
            throw new DNIException(DNIException.PARTE_LETRA_NO_CORRECTA);
        }
	}


	private static void listarAlumnos() {
        File file = new File("alumnos.dat");
        if (!file.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("\nLista de Alumnos:");
            while (true) {
                Alumno alumno = (Alumno) ois.readObject();
                System.out.println(alumno);
            }
        } catch (EOFException e) {
            System.out.println("Fin de la lista de alumnos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

	private static void borrarFichero() {
        File file = new File("alumnos.dat");
        if (file.exists() && file.delete()) {
            System.out.println("Fichero borrado.");
        } else {
            System.out.println("El fichero no existe o no se pudo borrar.");
        }
    }
}