package ejercicios.Ejercicio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio2 {
	
/*
 * Vamos a crear un programa que lea un fichero de propiedades, lo imprima 
 * por pantalla y permita al usuario modificar uno de los valores. 
 * Luego, el programa actualizará el fichero con los nuevos valores.
 */

	public static void main(String[] args) {

		// Ruta del archivo de propiedades
	        String archivoPropiedades = "src/ejercicios/Ejercicio2/config.properties";
	        // Crear objeto Properties
	        Properties propiedades = new Properties();
	 
	        try {
	            // Cargar el archivo de propiedades
	            FileInputStream input = new FileInputStream(archivoPropiedades);
	            propiedades.load(input);
	            input.close();
	 
	            // Imprimir propiedades actuales
	           System.out.println("Propiedades actuales:");
	            for (Object clave : propiedades.keySet()) {
	                Object valor = propiedades.get(clave);
	                System.out.println(clave + ": " + valor);
	            }
	 
	            // Preguntar al usuario si desea modificar una propiedad
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("\n¿Deseas modificar alguna propiedad? (sí/no): ");
	            String respuesta = scanner.nextLine();
	 
	            if (respuesta.equalsIgnoreCase("sí")) {
	                // Pedir el nombre de la propiedad a modificar
	                System.out.print("Introduce el nombre de la propiedad a modificar: ");
	                String clavePropiedad = scanner.nextLine();
	 
	                // Verificar si la propiedad existe
	                if (propiedades.containsKey(clavePropiedad)) {
	                    // Pedir el nuevo valor
	                    System.out.print("Introduce el nuevo valor para " + clavePropiedad + ": ");
	                    String nuevoValor = scanner.nextLine();
	 
	                    // Actualizar la propiedad
	                    propiedades.setProperty(clavePropiedad, nuevoValor);
	 
	                    // Guardar los cambios en el archivo
	                    FileOutputStream output = new FileOutputStream(archivoPropiedades);
	                    propiedades.store(output, null);
	                    output.close();
	 
	                    System.out.println("Propiedad " + clavePropiedad + " actualizada con éxito.");
	                } else {
	                    System.out.println("La propiedad especificada no existe.");
	                }
	            }
	 
	        } catch (IOException e) {
	            System.out.println("Error al leer o escribir el archivo de propiedades.");
	            e.printStackTrace();
	        }
	    }
	}
