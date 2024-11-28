package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainEj1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<AlumnoEj1> Alumnos = new ArrayList<>();

		String rutaArch = "alumnos.txt";
		
		 try (BufferedReader br = new BufferedReader(new FileReader(rutaArch))) {
	            String linea;

	            // Leo el archivo línea por línea
	            while ((linea = br.readLine()) != null) {
	                String[] datos = linea.split("\\|");

	                // Extraigo el 
	                String nombre = datos[0];
	                String grupo = datos[1];
	                double nota_media = Double.parseDouble(datos[2]);
	                double nota1eva = Double.parseDouble(datos[3]);
	                double nota2eva = Double.parseDouble(datos[4]);
	                
	                AlumnoEj1 alumno = new AlumnoEj1(nombre, grupo, nota_media, nota1eva, nota2eva);
	                // Creo un nuevo objeto con los datos leído.

	                // Añado el objeto Alumnos al ArrayList
	                Alumnos.add(alumno);
	            }
		 
		 
		 
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 
	        // for (AlumnoEj1 alumn : Alumnos) {
	     System.out.println("Media de aprobados en la primera evaluación: ");
	     System.out.println("Media de aprobados en la segunda evaluación: ");
	     System.out.println("Número suspensos en la primera evaluación: ");
	     System.out.println("Nota media del módulo de Acceso a Datos en la primera evaluación: ");
	     System.out.println("Nota media del módulo de Acceso a Datos en la segunda evaluación: ");
	}
}

