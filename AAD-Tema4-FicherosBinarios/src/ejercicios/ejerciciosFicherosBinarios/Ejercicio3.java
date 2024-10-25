package ejercicios.ejerciciosFicherosBinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Ejercicio3 {

    /*
     * Ejercicio fusionar y ordenar ficheros binarios.
     * Implementa el método Integer[] fusionar(String fichero1, String fichero2), al que se le pasan los nombres de dos 
     * ficheros binarios que contienen dos listas ordenadas de objetos Integer, y devuelve una tabla ordenada con todos
     * los elementos de los dos ficheros fusionados.
     * 
     * Realiza dos versiones:	a) Con Arrays  b) Con colecciones
     */
    
    public static void main(String[] args) {

    	Integer[] l1 = {3, 5, 7, 2, 8, 9};
    	Integer[] l2 = {4, 7, 9, 0, 1, 5, -1};
    	
    	try(ObjectOutputStream o1 = new ObjectOutputStream(
    			new FileOutputStream("fichero1.dat"));
    			ObjectOutputStream o2 = new ObjectOutputStream(
    			new FileOutputStream("fichero2.dat"))){
    		
    		o1.writeObject(l1);
    		o2.writeObject(l2);
    	} catch (IOException ex) {
    		System.out.println(ex);
    	}
    	
    	Integer[] rdo_final=fusionar("fichero1.dat", "fichero2.dat");
    	System.out.println(Arrays.toString(rdo_final));
    	
    }
    
    static Integer[] fusionar(String fichero1, String fichero2) {
    	Integer[] listaFusionada = null;
    	try(ObjectInputStream in1 = new ObjectInputStream(
    			new FileInputStream(fichero1));
    			ObjectInputStream in2 = new ObjectInputStream(
    			new FileInputStream(fichero2))){
    		
    		Integer[] lista1 = (Integer[]) in1.readObject();
    		Integer[] lista2 = (Integer[]) in2.readObject();
    		listaFusionada = new Integer[lista1.length + lista2.length];
    		System.arraycopy(lista1, 0, listaFusionada, 0, lista1.length);
    		System.arraycopy(lista2, 0, listaFusionada, lista1.length, lista2.length);
    		Arrays.sort(listaFusionada);
    		
    	} catch (IOException | ClassNotFoundException ex) {
    		System.out.println(ex);
    	}
    	return listaFusionada;
    }
}
