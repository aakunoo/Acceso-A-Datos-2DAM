package ejercicios;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args){
        if(args.length != 1){
            System.err.println("Numero de argumentos incorrecto, debes pasar 1.");
            return;
        }
        
        File ruta = new File(args[0]);
        
        if(!ruta.exists()){
            System.err.println("Ruta no válida, vuelva a ejecutar el programa");
            return;
        }
        System.out.printf("%-70s %-70s %-70s","Nombre","Ruta","Ruta absoluta");
        
		for ( File archivo : ruta.listFiles()) {
			System.out.printf(
					"%-70s %-70s %-70s\n",
			archivo.getName(),
			archivo.getPath(),
			archivo.getAbsolutePath());
		}
		
	}
 

}
