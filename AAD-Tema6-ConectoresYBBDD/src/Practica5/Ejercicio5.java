package Practica5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
		String user = sc.nextLine();
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); 

		
		try(Connection conexion = DriverManager.getConnection(url, user, password)){
	            String sentenciasql = "SELECT customer_id, SUM(unit_price * quantity) AS total_ventas " +
	                    "FROM order_items " +
	                    "JOIN orders ON order_items.order_id = orders.order_id " +
	                    "GROUP BY customer_id " +
	                    "HAVING SUM(unit_price * quantity) > ?";
	            
				PreparedStatement ps = conexion.prepareStatement(sentenciasql);
				ps.setDouble(1, 10000);
				
				ResultSet resultadoConsulta = ps.executeQuery();
				

	            System.out.println("Clientes con ventas superiores a 10000:");
	            System.out.println("-----------------------------------------");
	            while (resultadoConsulta.next()) {
	                int customerId = resultadoConsulta.getInt("customer_id");
	                double totalVentas = resultadoConsulta.getDouble("total_ventas");
	                System.out.println("Cliente ID: " + customerId + ", Total Ventas: " + totalVentas);
	            }

	            resultadoConsulta.close();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }
	    }
	}
