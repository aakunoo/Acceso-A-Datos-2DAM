package Practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
		String user = sc.nextLine();
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); 
		
		
		
		try(Connection conexion = DriverManager.getConnection(url, user, password);
				
			Statement consulta = conexion.createStatement()) {
	        String sentenciasql = "SELECT "
	        		+ "p.product_name," // Tabla products, alias p.
	        		+ "pc.category_name, " // Products Categories.
	        		+ "oi.unit_price " // Pertenece a la tabla order_items.
	        		+ "FROM "
	        		+ "order_items oi "
	        		+ "INNER JOIN products p ON oi.product_id = p.product_id "
	        		+ "INNER JOIN product_categories pc ON p.category_id = pc.category_id";
			
			ResultSet resultadoConsulta = consulta.executeQuery(sentenciasql);
			
			System.out.println("\nListado de productos pedidos con su información:");
			System.out.println("-------------------------------------------------");
			
			while (resultadoConsulta.next()) {
                String productos = resultadoConsulta.getString("product_name");
                String categoria = resultadoConsulta.getString("category_name");
                Double precio = resultadoConsulta.getDouble("unit_price");
                
                System.out.println("Producto: " + productos + ", Categoría: " + categoria + ", Precio por unidad: " + precio);
			}
			
			resultadoConsulta.close();
			sc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
