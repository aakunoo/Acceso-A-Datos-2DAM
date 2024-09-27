package practicas;
import java.io.File;

// Los comentarios son para mero uso personal.

public class Ejercicio1 {
    public static void main(String[] args) {
    	String dir=".."; // Creo variable tipo String que me lea el directorio actual.
    	File f= new File(dir); // Declaramos un objeto (f) y usamos constructor de File.
    	String[] archivos= f.list(); // Estoy haciendo una variable (array de string) donde yo recojo todos los valores que tiene esa f.º
    	System.out.printf("Ficheros en el directorio actual = %d %n",archivos.length); // archivos.length es para la longitud del array.
    	
    	// d: Para decimales. s: Para caracteres. b: Para boolean para que diga si es true o false y no haga falta if.
    	
    	for (int i = 0; i < archivos.length; i++) { // Usamos bucle for con índice i para recorrer todos los elementos del array archivos.
    		File f2 = new File (f, archivos[1]); // Creamos un nuevo objeto File para cada archivo o carpeta
    		System.out.printf("Nombre: %s es fichero?: %b, es directorio?: %b \n", archivos[i],f2.isFile(),f2.isDirectory());
    		// ?:Hace que no necesitemos if y se use lo de detras suyo para las distintas posibilidades que hay.		
    	}
    }
}