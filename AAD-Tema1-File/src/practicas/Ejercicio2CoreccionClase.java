package practicas;

import java.io.File;

public class Ejercicio2CoreccionClase {

	public static void main(String[] args) {

	if (args.length!=1) {
		System.out.println("Por favor, proporciona el nombre del directorio: ");
		return;
		
	}
	System.out.println("El argumento pasado es: "+ args[0]); //Crea un objeto File con el nombre del directorio proporcionado.
	File directorio= new File(args[0]); //Verifica si el directorio existe y si es válido.
	
	if(!directorio.exists()) {
		System.out.println("El directorio no existe.");
	}
		else if (!directorio.isDirectory()) {
			System.out.println("El nombre proporcionado no correspode al directorio.");
		}
		else {
			//Listar los ficheros del directorio.
			File[] ficheros=directorio.listFiles();
			if(ficheros !=null && ficheros.length>0) {
				System.out.println("Ficheros en el directorio"+ args[0] + ":");
			for (File fichero:ficheros) {
				System.out.println("Nombre: "+fichero.getName());
				System.out.println("Ruta: "+fichero.getPath());
				System.out.println("Ruta: "+fichero.getAbsolutePath());
			}
			}else {
				System.out.println("El directorio esta vacío.");
			}
			}
		}
}
	


