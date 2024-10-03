package practicas;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5 {

	/**
	 * Ejercicio: Contar números en fichero de texto.
	         String ruta=JOptionPane.showInputDialog(null, 
                         "Inserta la ruta del fichero", 
                         "Insercion", 
                         JOptionPane.INFORMATION_MESSAGE);
	 */
	public static void main(String[] args) {
		// Usamos JOptionPane para introducir la ruta del fichero
		String rutaFichero = JOptionPane.showInputDialog("Introduce la ruta del fichero.");
		
		File f = new File(rutaFichero);
		
		// Declaramos una variable para contar numerosEscritorio
		int contadorNumeros = 0;
		
		//Intentamos leer el archivo y contar numeros
		try {
            FileReader lector = new FileReader(f); // Abrimos el fichero para leerlo
            int caracter; // Declaramos variable para leer cada carácter del fichero.
	
           // Leer cada carácter del fichero.
            while ((caracter = lector.read())!=-1) {
            	
            	// Para comprobar si ese caracter es un numero
            	if (Character.isDigit(caracter)) {
            		contadorNumeros++; //Incrementa el contador si encontramos un numero.
            		
            		/*
            		 * Podemos usar en vez de esto, con codigo ASCII
            		 * if(c ) >= 48 && c <= 57){
            		 * 		contadorNumeros++
            		 * }
            		 */
            	}
            }
            //Para mostrar el resultado:
            JOptionPane.showMessageDialog(null, "El fichero contiene "+ contadorNumeros + " números.");
            System.out.println("El fichero "+f.getName()+ " contiene "+ contadorNumeros + " números.");
            
            lector.close();
            
		
		}catch (IOException e) {
		
			// Se muestra mensaje de error si no se puede leer el fichero.
			JOptionPane.showMessageDialog(null,"Ocurrió un error al leer el fichero, asegurate de qué la ruta es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error. " + e.getMessage());
		}
		
	}
}


