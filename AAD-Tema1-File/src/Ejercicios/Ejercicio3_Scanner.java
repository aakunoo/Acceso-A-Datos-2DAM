package ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Ejercicio3_Scanner {
	

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Ponle nombre al directorio: ");
    	String gordito = sc.nextLine();

    	
    	File dir= new File(gordito); //Crea un fichero en nuestro directorio actual
    	
    	if(dir.exists()) {
    		
    		System.out.println("El directorio ya existe.");
    	}else {
    		
    		dir.mkdir();
    		System.out.println("Se ha creado el directorio.");
    	}
    	System.out.println("Ponle nombre al primer fichero que quieres crear: ");
    	String gordito2 = sc.nextLine();
    	File arch1=new File(dir, gordito2);

    	try {
    		if(arch1.exists()) {
    			System.out.println("El fichero que quieres crear ya existe.");
    		}else {
    			
    			arch1.createNewFile();
    			System.out.println("Se ha creado el fichero indicado con nombre: "+ arch1.getName());
    		}
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el fichero "+e.getMessage());
		}
    	
    	System.out.println("Ahora ponle nombre al ultimo fichero que quieres crear: ");
    	String gordito3 = sc.nextLine();
    	File arch2=new File(dir,gordito3);
    
    	try {
    		if(arch2.exists()) {
    			System.out.println("El segundo fichero que quieres crear ya existe.");
    		}else {
    			
    			arch2.createNewFile();
    			System.out.println("Has creado el segundo fichero con el nombre de: "+ arch2.getName());
    			
    			System.out.println("Vamos a renombrarlo! Que nombre quieres ponerle a tu ultimo fichero creado?: ");
    			String gordito4 = sc.nextLine();
       			File archrenombre = new File(dir,gordito4);
    			arch2.renameTo(archrenombre);
    			System.out.println("Has cambiado con éxito el nombre del segundo fichero a: "+  archrenombre.getName());
    		}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el fichero "+e.getMessage());
			
		}finally {
			
		}
    	sc.close();
    	
    	}
}     