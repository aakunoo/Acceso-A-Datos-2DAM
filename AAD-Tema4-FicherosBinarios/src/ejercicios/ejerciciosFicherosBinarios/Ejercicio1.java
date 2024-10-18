package ejercicios.ejerciciosFicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	/*

	Crear una aplicación en Java en la que haya un menú que permita introducir datos de diferentes 
	usuarios ( NIF, nombre, apellidos. edad, expectativa salarial)

	Se podrán ir añadiendo usuarios con estos datos hasta que el usuario elija la opción N (de no) 
	donde finalizará la ejecución del programa.

	Los datos introducidos de los diferentes usuarios deberán ser almacenados en fichero  
	binario llamado usuarios.dat

	 */
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean booleano = true;

        
        String archivo = "src/ejercicios/ejerciciosFicherosBinarios/usuariosv2.dat";
        while (booleano) {
        	
            System.out.println("Menú:");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            
            scanner.nextLine(); 

            if (opcion == 1) {
                DataOutputStream dos = null;
                try {
                	
                    dos = new DataOutputStream(new FileOutputStream(archivo, true)); // El true es para que no se borre cuando se meten mas datos.

                    System.out.print("Introduce el NIF: ");
                    String NIF = scanner.nextLine();

                    System.out.print("Introduce el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce los apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.print("Introduce la edad: ");
                    int edad = scanner.nextInt();

                    System.out.print("Introduce la expectativa salarial: ");
                    double expectativaSalarial = scanner.nextDouble();
                    
                    scanner.nextLine(); 

                    dos.writeUTF(NIF);
                    dos.writeUTF(nombre);
                    dos.writeUTF(apellidos);
                    dos.writeInt(edad);
                    dos.writeDouble(expectativaSalarial);

                    System.out.println("Usuario añadido correctamente.");
                } catch (IOException e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                } finally {
  
                    if (dos != null) {
                        try {
                            dos.close();
                        } catch (IOException e) {
                            System.out.println("Error al cerrar el archivo.");
                        }
                    }
                }

   
            } else if (opcion == 2) {
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(new FileInputStream(archivo));

                    System.out.println("Usuarios guardados:\n");

                    while (dis.available() > 0) { 
                        String NIF = dis.readUTF();
                        String nombre = dis.readUTF();
                        String apellidos = dis.readUTF();
                        int edad = dis.readInt();
                        double expectativaSalarial = dis.readDouble();

                        System.out.println("NIF: " + NIF + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Expectativa Salarial: " + expectativaSalarial);
                    }

                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                } finally {
            
                    if (dis != null) {
                        try {
                            dis.close();
                        } catch (IOException e) {
                            System.out.println("Error al cerrar el archivo.");
                        }
                    }
                }

   
            } else if (opcion == 3) {
                booleano = false;
                System.out.println("Saliendo del programa.");
            
 
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}
