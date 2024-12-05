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
			String sentenciasql = """
		            SELECT 
		                c.name AS customer_name,
		                SUM(oi.quantity * oi.unit_price) AS total_sales
		            FROM 
		                orders o
		            INNER JOIN customers c ON o.customer_id = c.customer_id
		            INNER JOIN order_items oi ON o.order_id = oi.order_id
		            GROUP BY 
		                c.name
		            HAVING 
		                SUM(oi.quantity * oi.unit_price) > ?
		            ORDER BY 
		                total_sales DESC
		            """;
	            // Crear un objeto PreparedStatement para preparar la consulta SQL con parámetros
				PreparedStatement ps = conexion.prepareStatement(sentenciasql);
				ps.setDouble(1, 10000); // valor límite para las ventas mayores a 10,000
				
				ResultSet resultadoConsulta = ps.executeQuery();
				

	            System.out.println("Clientes con ventas superiores a 10000:");
	            System.out.println("-----------------------------------------");
	            while (resultadoConsulta.next()) {
	                String customerNombre = resultadoConsulta.getString("customer_name");
	                double totalVentas = resultadoConsulta.getDouble("total_sales");
	                System.out.println("Nombre Cliente: " + customerNombre + ", Total Ventas: " + totalVentas);
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
