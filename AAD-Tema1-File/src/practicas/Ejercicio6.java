package practicas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * Ejercicio aplicación java que elimine los espacios en blanco y convierta todos los caracteres a mayúsculas
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        // Primero se pide la ruta del fichero.
        String ruta = JOptionPane.showInputDialog("Introduce la ruta del fichero a modificar: ");

        try {
            // Luego se lee el fichero original
            FileReader lector = new FileReader(ruta);  // Abrimos el fichero para leerlo
            String contenido = "";  // Creo la variable para almacenar todo el contenido del archivo

            int caracter;  // Creo una variable que almacena cada carácter leído
            
            // Usamos un bucle while para leer el fichero carácter por carácter
            
            while ((caracter = lector.read()) != -1) {
                char c = (char) caracter;  // Convertimos el código leído en carácter
                
                // Ahora verificamos que no sea un espacio en blanco
                if (!Character.isWhitespace(c)) {
                    // Convertimos el carácter a mayúsculas y lo agregamos a la variable 'contenido'
                    contenido += Character.toUpperCase(c);
                }
            }
            lector.close();  // Cerramos el lector después de haber leído todo el archivo

            // para escribir el contenido procesado en el mismo archivo (sobrescribiendo)
            
            FileWriter boli = new FileWriter(ruta);  // Abrimos el fichero en modo escritura (sobrescribiendo)
            boli.write(contenido);  // Escribimos el contenido procesado (sin espacios y en mayúsculas)
            boli.close();  // Cerramos el escritor

            // para mostrar un mensaje de éxito al usuario
            
            JOptionPane.showMessageDialog(null, "El fichero ha sido modificado correctamente.");
            System.out.println("El fichero ha quedado reescrito de la siguiente forma: "+ "\n"); // Para mostrarlo en consola
            System.out.println(contenido);
        } catch (IOException e) {
        	
            // Para los errores que puedan ocurrir
        	
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el fichero. Asegúrate de que la ruta es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

/* Ejercicio corregido en clase hecho de otra forma:
 
	  // Crear un objeto Scanner para leer desde la entrada estándar (teclado)
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Inserta la ruta del fichero: ");
	        String ruta = scanner.nextLine();
	        //Abrimos el stream de lectura
	        //Abrimos otro de escritura (otro fichero distinto)
	        try(FileReader fr=new FileReader(ruta);
	                FileWriter fw=new FileWriter("C:\\AD\\convertFile.txt")){
	            int caracter;
	            String resultado="";
	            //leemos el fichero
	            while( (caracter = fr.read()) != -1 ){
	                if(caracter >=97 && caracter <=122){ //Si es una minuscula, la pasamos a mayuscula 
	                    resultado+=((char)(caracter-32));
	                }else if(caracter!=32){ //Si es un espacio, no lo escribimos en el fichero
	                    resultado+=(char)(caracter);
	                }
	            }
	            //Guardamos el resultado en el nuevo fichero
	            fw.write(resultado);
	        }catch(IOException e){
	            System.out.println("Error");
	        }

	    }
	}
	
*/
