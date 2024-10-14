package practicas;

import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

/*
 *  Ejercicio de notas con Ficheros
 */


public class Ejercicio10 {

	public static void main(String[] args) {
		
		 String rutaArch = "C:\\Users\\Manana\\Desktop\\Acceso-Datos-DAM2\\ADD-Tema2-FicherosTexto\\Ejercicio10Archivo\\notas.txt";
		 
	     Scanner sc = new Scanner(System.in);
	     System.out.print("Introduce una nota de corte: ");
	     int notaDeCorte = sc.nextInt();
	     
	        try {
	            File archivo = new File(rutaArch);
	            Scanner scanner = new Scanner(archivo);

	            System.out.println("Las notas mayores a la nota de corte son:");
	            while (scanner.hasNextInt()) {
	                int nota = scanner.nextInt();
	                if (nota > notaDeCorte) {
	                    System.out.println(nota);
	                }
	            }
	            
	            scanner.close();
	            
	        } catch (FileNotFoundException e) {
	            System.out.println("No se pudo encontrar el archivo: " + rutaArch);
	            e.printStackTrace();
	            
	        }
	        
	        sc.close();
	}

}
