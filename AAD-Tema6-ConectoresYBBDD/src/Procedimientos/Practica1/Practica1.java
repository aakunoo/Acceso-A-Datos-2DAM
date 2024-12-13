package Procedimientos.Practica1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
		
		// Obtener datos del pedido.
		System.out.println("Introduce el ID del cliente: ");
		int customerId = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduce el estado del pedido: ");
        String status = sc.nextLine();
        
        System.out.println("Introduce el ID del vendedor: ");
        int salesman_id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduce la fecha del pedido (YYYY-MM-DD) ");
        String orderDateInput = sc.nextLine();
        Date orderDate = Date.valueOf(orderDateInput);
		
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
	        String llamProc = "{CALL nuevo_pedido(?, ?, ?, ?)}"; // CALL para llamar al procedimiento.
			 try (CallableStatement cs = conexion.prepareCall(llamProc)) {
	            cs.setInt(1, customerId);
	            cs.setString(2, status);
	            if (salesman_id > 0) {
	                cs.setInt(3, salesman_id);
	            } else {
	                cs.setNull(3, java.sql.Types.INTEGER);
	            }
	            cs.setDate(4, orderDate);
	
	            // Ejecutar el procedimiento
	            cs.execute();
	            System.out.println("Nuevo pedido insertado correctamente.");
        }

    } catch (SQLException e) {
        System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
        e.printStackTrace();
    } finally {
        sc.close();
    }
}
}