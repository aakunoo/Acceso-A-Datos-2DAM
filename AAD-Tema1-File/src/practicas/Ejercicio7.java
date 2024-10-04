package practicas;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// Ejercicio BufferedReader BufferedWriter.

public class Ejercicio7 {
    public static void main(String[] args) {
        // Definir la ruta del fichero
        String rutaFichero = "miFichero.txt";

        // Para llamar al metodo de escribir en el fichero
        escribirFicheroB(rutaFichero);

        // Para llamar al metodo de leer el fichero escrito
        leerFicheroB(rutaFichero);
    }

    // Creo el metodo para escribir en el fichero usando BufferedWriter
    public static void escribirFicheroB(String rutaFichero) {
        try {
            // Creo un objeto BufferedWriter para escribir en el archivo
            BufferedWriter bescritor = new BufferedWriter(new FileWriter(rutaFichero));

            // Para escribir la primera línea en el archivo
            bescritor.write("El módulo de Acceso a Datos");

            // Asi se inserta una linea nueva
            bescritor.newLine(); 

            // Para escribir la segunda linea
            bescritor.write("es muy útil para aprender");

            // Se cierra el BufferedWriter para guardar los cambios y liberar recursos
            bescritor.close();  

            System.out.println("Fichero escrito correctamente.");
        } catch (IOException e) {
            // Manejo de excepciones en caso de error
            System.out.println("Ocurrió un error al escribir en el fichero.");
            e.printStackTrace();
        }
    }

    // Creo metodo para leer el contenido del fichero usando BufferedReader
    public static void leerFicheroB(String rutaFichero) {
        try {
            // Para crear un objeto BufferedReader para leer el archivo
            BufferedReader blector = new BufferedReader(new FileReader(rutaFichero));

            String linea;  // Variable para almacenar cada línea leída

            // Leer línea por línea hasta llegar al final del archivo
            while ((linea = blector.readLine()) != null) {
                // Mostrar cada línea leída
                System.out.println(linea);
            }

            // Cerrar el BufferedReader para liberar recursos
            blector.close();  

        } catch (IOException e) {
            // Manejo de excepciones en caso de error
        	
            System.out.println("Ocurrió un error al leer el fichero.");
            e.printStackTrace();
        }
    }

 
}
