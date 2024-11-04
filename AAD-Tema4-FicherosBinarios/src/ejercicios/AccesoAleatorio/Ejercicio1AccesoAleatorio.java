package ejercicios.AccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1AccesoAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw");
			
            raf.writeInt(123); // Escribir un entero
            raf.writeDouble(45.67); // Escribir un double
            raf.writeUTF("Hola, mundo"); // Escribir una cadena en formato UTF

            raf.close();
            System.out.println("Datos escritos correctamente.");

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
				RandomAccessFile raf = new RandomAccessFile("datos.bin", "r");
				
	            int entero = raf.readInt();
	            double doble = raf.readDouble();
	            String cadena = raf.readUTF();
	            
	            // Mostrar los datos leídos
	            System.out.println("Entero: " + entero);
	            System.out.println("Double: " + doble);
	            System.out.println("Cadena: " + cadena);
	            
	            // Cerrar el fichero
	            raf.close();

				
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				RandomAccessFile raf = new RandomAccessFile("datos.bin", "r");
				
	            raf.seek(4);
	            double doble = raf.readDouble();
	            
	            // Mostrar el double leído
	            System.out.println("Double leído: " + doble);
	            
	            // Cerrar el fichero
	            raf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}	
	}

}
