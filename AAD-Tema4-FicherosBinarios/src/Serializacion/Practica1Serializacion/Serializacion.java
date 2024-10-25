package Serializacion.Practica1Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Serializacion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el nombre: ");
		String nombre = sc.nextLine();
		
		System.out.print("Introduce los apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Introduce la nota que estimas sacar en Acceso a Datos: ");
        double notaAD = sc.nextDouble();
        
        Alumno alumno = new Alumno(nombre, apellidos, notaAD);
        
        	try {
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("alumno.ser"));
				oos.writeObject(alumno);
				System.out.println("Alumno creado con éxito.");
				
			} catch (IOException e) {
				System.out.println("Error con la serialización.");
				e.printStackTrace();
			}
        	
        	try {
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream("alumno.ser"));
				 alumno = (Alumno) ois.readObject();
				 System.out.println(alumno);
				
			} catch (IOException e) {
				
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
	}


