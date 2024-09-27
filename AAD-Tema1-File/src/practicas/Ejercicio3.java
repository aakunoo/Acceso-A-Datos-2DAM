package practicas;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
	

    
    public static void main(String[] args){
    	File dir= new File("AADPrueba1"); //Crea un fichero en nuestro directorio actual
    	
    	if(dir.exists()) {
    		
    		System.out.println("El directorio ya existe.");
    	}else {
    		
    		dir.mkdir();
    		System.out.println("Se ha creado el directorio.");
    	}
    	
    	
    	File arch1=new File(dir,"Matenme.txt");

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
    	
    	File arch2=new File(dir,"zurron_feo.txt");
    
    	try {
    		if(arch2.exists()) {
    			System.out.println("El segundo fichero que quieres crear ya existe.");
    		}else {
    			File archrenombre = new File(dir,"zurron_guapo.txt");
    			arch2.createNewFile();
    			System.out.println("Se ha creado el segundo fichero indicado llamado: "+ arch2.getName());
    			arch2.renameTo(archrenombre);
    			System.out.println("Has cambiado con éxito el nombre del segundo fichero a: "+  archrenombre.getName());
    		}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("No se pudo crear el fichero "+e.getMessage());
			
		}
    	
    	}
}     