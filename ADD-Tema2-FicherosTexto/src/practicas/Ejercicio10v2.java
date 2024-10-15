package practicas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio10v2 {
    public static void main(String[] args) {
        // Para definir la ruta de ambos archivos
        String rutaArchivo = "./Ejercicio10Archivo/notas.txt"; // Asegúrate de colocar la ruta correcta
        String archivoSuspensos = "./Ejercicio10Archivo/suspensos.txt"; // Archivo para los suspensos

        // Leemos las notas y luego escribimos las inferiores a 5 en suspensos.txt
        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);
            FileWriter writer = new FileWriter(archivoSuspensos); // Para escribir los suspensos

            // Leemos cada nota del archivo
            while (scanner.hasNextInt()) {
                int nota = scanner.nextInt();

                // Escribimos en el archivo de suspensos las notas menores a 5
                if (nota < 5) {
                    writer.write(nota + "\n");
                }
            }

            scanner.close();
            writer.close();
            System.out.println("Se han escrito los suspensos en " + archivoSuspensos);

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + rutaArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + archivoSuspensos);
            e.printStackTrace();
        }
    }
}