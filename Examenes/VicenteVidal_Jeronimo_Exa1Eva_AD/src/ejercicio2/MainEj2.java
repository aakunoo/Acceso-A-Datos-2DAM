package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainEj2 implements Serializable {

	public static void main(String[] args) {

		
		File arch = new File("cfvb.ser");
		ObtenerFichero(arch);
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arch))) {
			System.out.println("Ciclos formativos guardados correctamente en el archivo ");
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
		} catch(IOException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
public static void ObtenerFichero(File arch) {
	

	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arch))){
		

		CFEj2 ciclo = new CFEj2 ("Técnico en Sistemas MicroInformáticos y Redes ", "grado medio", 1800);
		oos.writeObject(ciclo);
		CFEj2 ciclo2 = new CFEj2 ("Técnico en Desarrollo de Aplicaciones Web ", "grado superior", 2000);
		oos.writeObject(ciclo2);
		CFEj2 ciclo3 = new CFEj2 ("Técnico en Desarrollo de Aplicaciones Multiplataforma ", "grado superior", 2000);
		oos.writeObject(ciclo3);
		CFEj2 ciclo4 = new CFEj2 ("Técnico Superior en Administración de Sistemas Informáticos en Red Multiplataforma ", "grado superior", 2000);
		oos.writeObject(ciclo4);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
