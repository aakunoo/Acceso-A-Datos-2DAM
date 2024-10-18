package ejercicios.ejerciciosFicherosBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	/*
	 
	Lee el anterior fichero binario y muestra por pantalla su contenido.

	El programa además deberá poder introducir un valor para la expectativa salarial y 
	mostrar los usuarios que tiene un valor mayor que esa expectativa.
	
	 */
	public static void main(String[] args) {
		   Scanner scanner = new Scanner(System.in);


	        String archivo = "src/ejercicios/ejerciciosFicherosBinarios/usuariosv2.dat";

	        DataInputStream dis = null;
	        try {
	            dis = new DataInputStream(new FileInputStream(archivo));

	            System.out.println("Usuarios guardados: \n");
	            while (dis.available() > 0) { 
	                String dni = dis.readUTF();
	                String nombre = dis.readUTF();
	                String apellidos = dis.readUTF();
	                int edad = dis.readInt();
	                double expectativaSalarial = dis.readDouble();

	
	                System.out.println("DNI: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Expectativa Salarial: " + expectativaSalarial);
	            }

	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        } finally {
	            if (dis != null) {
	                try {
	                    dis.close();
	                } catch (IOException e) {
	                    System.out.println("Error al cerrar el archivo.");
	                }
	            }
	        }

	        System.out.print("\nIntroduce una expectativa salarial para filtrar usuarios: ");
	        double filtroSalario = scanner.nextDouble();

	        try {
	            dis = new DataInputStream(new FileInputStream(archivo));

	            System.out.println("Usuarios con expectativa salarial mayor que \n" + filtroSalario + ":");
	            while (dis.available() > 0) { 
	                String dni = dis.readUTF();
	                String nombre = dis.readUTF();
	                String apellidos = dis.readUTF();
	                int edad = dis.readInt();
	                double expectativaSalarial = dis.readDouble();

	                if (expectativaSalarial > filtroSalario) {
	                    System.out.println("DNI: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Expectativa Salarial: " + expectativaSalarial);
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo para aplicar el filtro: " + e.getMessage());
	        } finally {
	            if (dis != null) {
	                try {
	                    dis.close();
	                } catch (IOException e) {
	                    System.out.println("Error al cerrar el archivo.");
	                }
	            }
	        }

	        scanner.close();
	    }
	}