package Ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
	

    
    public static void main(String[] args){
    	File dir= new File("AADEJ"); //Crea un fichero en nuestro directorio actual
    	dir.mkdir();
    	File arch1=new File(dir,"arch1.text");
    
    	try {
			arch1.createNewFile();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el fichero "+e.getMessage());
		}
    	
    	File arch2=new File("arch2.txt");
    
    	try {
    		arch2.createNewFile();
    		arch2.renameTo(new File(dir,"archrename"));
    		
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el fichero "+e.getMessage());
			
		}
    	
    	}
}     