package Triggers.Practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Practica1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
		String user = sc.nextLine();
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); 

		
		 String sentenciaSQL = "UPDATE inventories SET quantity = ? WHERE product_id = ?";
	
		 PreparedStatement consulta = null;
	        
	        
	        try (Connection conexion = DriverManager.getConnection(url, user, password)){
	        	while (true) {
	                System.out.println("\nIntroduce un ID de producto (0 para salir): ");
	                int productId = sc.nextInt();
	                sc.nextLine(); 
	                if (productId == 0) {
	                    System.out.println("Saliendo del programa...");
	                    break; 
	                }

	                System.out.println("Introduce una cantidad: ");
	                int cantidad = sc.nextInt();
	                sc.nextLine(); 

	                // llamada al método para actualizar la tabla
	                actualizarInventario(conexion, productId, cantidad);
	            }
	        	
	        } catch (SQLException e) {
	            System.out.println("Error de conexión SQL: " + e.getMessage());
	        } finally {
	            sc.close();
	        }
	    }

private static void actualizarInventario(Connection conexion, int productId, int cantidad) {
    String sentenciaSQL = "UPDATE inventories SET quantity = ? WHERE product_id = ?";

    try (PreparedStatement consulta = conexion.prepareStatement(sentenciaSQL)) {
        consulta.setInt(1, cantidad);
        consulta.setInt(2, productId);
        consulta.executeUpdate();
        System.out.println("El update se ejecutó con éxito para el producto con ID " + productId);
    } catch (SQLException e) {
        System.out.println("Error SQL al actualizar el producto: " + e.getMessage());
    }
}
}