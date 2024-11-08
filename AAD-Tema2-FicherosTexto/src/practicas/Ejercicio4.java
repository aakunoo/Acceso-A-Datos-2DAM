package practicas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Ejercicios de Ficheros de texto secuenciales. Clases FileReader y FileWriter.

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ruta = "C:\\Users\\Manana\\Desktop\\Acceso-Datos-DAM2\\AAD-Tema1-File\\FicheroEjercicio4\\ejercicio4.txt";
		
		try (FileWriter escritor = new FileWriter(ruta)){
			
			// Escribo el contenido en dos lineas.
			escritor.write("Estamos en Acceso a datos.\n");
			escritor.write("Somos de Segundo de DAM.\n");
			
			System.out.println("El fichero se ha creado correctamente. ");
		}catch (IOException e) {
			
			System.out.println("Ha habido un error a la hora de crear este fichero. ");
			
			e.printStackTrace();
		}
		
		try (FileReader lector = new FileReader(ruta)){ // Creo el filereader para leer el archivo con texto.
			
			int data;
			while ((data = lector.read()) != -1) {
				
				System.out.print((char)data);
			}
			
		}catch (IOException e) {
			
	
            e.printStackTrace();

		}
	}

}
