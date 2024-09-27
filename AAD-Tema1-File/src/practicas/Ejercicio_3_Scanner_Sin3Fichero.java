package practicas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
public class Ejercicio_3_Scanner_Sin3Fichero {
 
    public static void main(String[] args) {
        // Usar Scanner para pedir el nombre del directorio por teclado y quitar el Hardcoding visto en clase
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del directorio a crear: ");
        String nombreDirectorio = sc.nextLine();
 
        // Crear el objeto File para el directorio con el nombre ingresado
        File directorio = new File(nombreDirectorio);
 
        // Comprobar si el directorio ya existe
        if (!directorio.exists()) {
            // Intenta crear el directorio
            if (directorio.mkdir()) {
                System.out.println("Directorio creado: " + nombreDirectorio);
            } else {
                System.out.println("Error al crear el directorio.");
                sc.close();
                return;
            }
        } else {
            System.out.println("El directorio ya existe.");
        }
 
        // Crear los nombres de los dos ficheros vacíos
        File fichero1 = new File(directorio, "fichero1.txt");
        File fichero2 = new File(directorio, "fichero2.txt");
 
        try {
            // Crear los dos ficheros vacíos con su correspondiente comprobación.
            if (fichero1.createNewFile()) {
                System.out.println("Fichero creado: " + fichero1.getName());
            } else {
                System.out.println("El fichero " + fichero1.getName() + " ya existe.");
            }
 
            if (fichero2.createNewFile()) {
                System.out.println("Fichero creado: " + fichero2.getName());
            } else {
                System.out.println("El fichero " + fichero2.getName() + " ya existe.");
            }
            fichero1.renameTo(new File(nombreDirectorio,"ficheroQueRenombro.txt"));
            /*
            // Renombrar fichero2.txt a ficheroRenombrado.txt
            File ficheroRenombrado = new File(directorio, "ficheroRenombrado.txt");
            if (fichero2.renameTo(ficheroRenombrado)) {
                System.out.println("Fichero renombrado a: " + ficheroRenombrado.getName());
            } else {
                System.out.println("No se pudo renombrar el fichero.");
            }
	*/
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear los ficheros: " + e.getMessage());
        } finally {
            sc.close(); // Cerrar el Scanner
        }
    }
}