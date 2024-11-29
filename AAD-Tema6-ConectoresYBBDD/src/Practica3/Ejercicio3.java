package Practica3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "OT";
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); // Con Scanner.
		
		
		try(Connection conexion = DriverManager.getConnection(url, user, password);
			
			Statement consulta = conexion.createStatement()) {
			String sentenciasql = "SELECT employee_id, first_name, last_name FROM employees WHERE job_title LIKE 'Pro%'";
			ResultSet resultadoConsulta = consulta.executeQuery(sentenciasql);
			
			System.out.println("\nID\tNombre\tApellido");
			System.out.println("------------------------");
            while (resultadoConsulta.next()) {
                int id = resultadoConsulta.getInt("employee_id");
                String nombre = resultadoConsulta.getString("first_name");
                String apellido = resultadoConsulta.getString("last_name");

                System.out.println(id + "\t" + nombre + "\t" + apellido);
            }
			
		resultadoConsulta.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
