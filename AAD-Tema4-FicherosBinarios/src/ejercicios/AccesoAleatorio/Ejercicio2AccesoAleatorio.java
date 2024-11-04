package ejercicios.AccesoAleatorio;

/*
	Escribe con RandomAccessFile un fichero con los siguientes datos de 5 productos
	- id (int)
	- nombre (String, 10 caracteres)
	- precio (double)
	- descuento (boolean
	- tipo (char)
	Lee el segundo registro.

 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio2AccesoAleatorio {

	public static void main(String[] args) {

		String ruta = "ficheroejercicio2.bin";
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(ruta, "rw");
			int[] ids = {1, 2, 3, 4, 5};
            String[] nombres = {"Productos1", "Productos2", "Productos3", "Productos4", "Productos5"};
            double[] precios = {10.99, 20.99, 30.99, 40.99, 50.99};
            boolean[] descuentos = {true, false, true, false, true};
            char[] tipos = {'A', 'B', 'A', 'B', 'C'};
			
			for (int i = 0; i < 5; i++) {
				raf.writeInt(ids[i]);
				raf.writeUTF(nombres[i]);
				raf.writeDouble(precios[i]);
				raf.writeBoolean(descuentos[i]);
				raf.writeChar(tipos[i]);
			}
            
			System.out.println("Datos de los productos escritos correctamente.");
			
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
			
		} 
		
            try {
				raf = new RandomAccessFile(ruta, "r");
				raf.seek(81);
				
				System.out.println("ID: " + raf.readInt());
				System.out.println("Nombre: " + raf.readUTF());
				System.out.println("Precio: " + raf.readDouble());
				System.out.println("Descuento: " + raf.readBoolean());
				System.out.println("Tipo: " + raf.readChar());
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
